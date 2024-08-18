require "rails_helper"
require "shared_contexts/vcr/s3"
require 'shared_contexts/report_run'

# all reports are custom report
RSpec.describe ReportRuns::RunCustomReport do

  # describe "#execute", :versioning do
  describe "#execute" do
    include_context "vcr s3 put pdf report_run"

    let(:account) { create :account }
    let(:trial) { create :trial, :active, account: account }

    let(:user) { create :user }
    let(:role) { create :role, account: account }
    let(:user_role) { create :user_role, user: user, role: role, context: trial }

    # imamo 2 opcije (in this rspec the second is used):

    # 1. ovu što sam ja izbunario
    # let(:preferences) { {workflow_run_show: [role.id], view_hidden_sd: [role.id]} }

    # 2. da ovako definišeš stvari (add slot_visibility to slot & workflow run)
    # let(:slot) { create :source_document_slot, workflow: workflow }
    # let(:slot_visibility) { {slot.id.to_s => "visible"} }
    # let(:workflow_run1) { create :workflow_run, slot_visibility: slot_visibility, person_type: "Subject", person_id: subject_1.id, workflow: workflow, workflow_app: workflow_app }

    # workflow grants are set during workflow creation not regulary through grants
    # preferences/sd_permissions are grants for workflow, look in workflow builder / on creation / workflow settings & source document permissions
    # use in rails c to find all workflow preferences: Workflow.last.preferences
    let(:preferences) { {workflow_run_show: [role.id]} }
    # use in rails c to find all source documents permissions: Workflow.last.sd_permissions
    let(:sd_permissions) do
      { original_source_document_index: [role.id], original_source_document_show: [role.id],
        translated_source_document_index: [role.id], translated_source_document_show: [role.id],
        redacted_source_document_index: [role.id], redacted_source_document_show: [role.id],
        final_source_document_index: [role.id], final_source_document_show: [role.id] }
    end

    # it's ok to use admin user with preferences/sd_permissions because admin can use any permissions
    let(:workflow) { create :workflow, :status_force_approved, preferences: preferences, sd_permissions: sd_permissions, trial: trial, version_number: 1, workflow_apps: [workflow_app] }
    let(:workflow_app) { create :workflow_app, trial: trial}
    let(:category) { create :source_document_category, workflow: workflow }

    let(:slot) { create :source_document_slot, category: category, workflow: workflow }
    let(:slot_visibility) { {slot.id.to_s => "visible"} }

    # let(:first_version) { sdf.versions[0] }
    # let(:second_version) { sdf.versions[1] }

    # let(:compound_group) { create :substudy_group, trial: trial }
    # let(:study_group) { create :substudy_group, trial: trial, position: 2 }
    # *** Layers Configuration: ***
    # Compound 1
    #   Study 1
    #     Trial Site 1
    #       Subject 1
    #   Study 2
    #     Trial Site 2
    #       Subject_2
    # Compound 2
    #   Study 3
    #     Trial Site 3_1
    #       Subject 3_1
    #     Trial Site 3_2
    #       Subject 3_2
    # let(:compound_1) { create :substudy, trial: trial, substudy_group_id: compound_group.id }
    # let(:study_1) { create :substudy, trial: trial, substudy_group_id: study_group.id, ancestry: compound_1.id }
    # let(:study_2) { create :substudy, trial: trial, substudy_group_id: study_group.id, ancestry: compound_1.id }
    # let(:compound_2) { create :substudy, trial: trial, substudy_group_id: compound_group.id }
    # let(:study_3) { create :substudy, trial: trial, substudy_group_id: study_group.id, ancestry: compound_2.id }
    # instead of above configuration include from another file
    include_context "report run layers"

    let(:trial_site_1) { create :trial_site, :recruiting, trial: trial, substudy_id: study_1.id }
    let(:subject_1) { create :subject, trial_site: trial_site_1, trial: trial }
    let(:workflow_run_1) { create :workflow_run, :with_selected_outcome, :with_data, :status_completed, slot_visibility: slot_visibility, person_type: "Subject", person_id: subject_1.id, workflow: workflow, workflow_app: workflow_app }
    let(:sdf_1) { create :source_document_file, :file_type_main, :file_kind_original, :status_completed, :with_date_performed, workflow_run: workflow_run_1, slot: slot }

    let(:trial_site_2) { create :trial_site, :recruiting, trial: trial, substudy_id: study_2.id }
    let(:subject_2) { create :subject, trial_site: trial_site_2, trial: trial }
    let(:workflow_run_2) { create :workflow_run, :with_selected_outcome, :with_data, :status_in_progress, slot_visibility: slot_visibility, person_type: "Subject", person_id: subject_2.id, workflow: workflow, workflow_app: workflow_app }
    let(:sdf_2) { create :source_document_file, :file_type_main, :file_kind_original, :status_completed, :with_date_performed, workflow_run: workflow_run_2, slot: slot }

    let(:trial_site_3_1) { create :trial_site, :recruiting, trial: trial, substudy_id: study_3.id }
    let(:subject_3_1) { create :subject, trial_site: trial_site_3_1, trial: trial }
    let(:workflow_run_3_1) { create :workflow_run, :with_selected_outcome, :with_data, :status_in_progress, slot_visibility: slot_visibility, person_type: "Subject", person_id: subject_3_1.id, workflow: workflow, workflow_app: workflow_app }
    let(:sdf_3_1) { create :source_document_file, :file_type_main, :file_kind_original, :status_ready_for_signature,  :with_date_performed, workflow_run: workflow_run_3_1, slot: slot }

    let(:trial_site_3_2) { create :trial_site, :recruiting, trial: trial, substudy_id: study_3.id }
    let(:subject_3_2) { create :subject, trial_site: trial_site_3_2, trial: trial }
    let(:workflow_run_3_2) { create :workflow_run, :with_selected_outcome, :with_data, :status_in_progress, slot_visibility: slot_visibility, person_type: "Subject", person_id: subject_3_2.id, workflow: workflow, workflow_app: workflow_app }
    let(:sdf_3_2) { create :source_document_file, :file_kind_original, :status_completed, :with_date_performed, workflow_run: workflow_run_3_2, slot: slot }

    # Define data in one more trial
    let(:other_trial) { create :trial, :active, account: account }
    let(:other_workflow) { create :workflow, :status_force_approved, preferences: preferences, sd_permissions: sd_permissions, trial: other_trial, version_number: 1, workflow_apps: [other_workflow_app] }
    let(:other_workflow_app) { create :workflow_app, trial: other_trial }
    let(:other_category) { create :source_document_category, workflow: other_workflow }
    let(:other_slot) { create :source_document_slot, category: other_category, workflow: other_workflow }
    let(:other_slot_visibility) { {other_slot.id.to_s => "visible"} }
    # let(:other_compound_group) { create :substudy_group, trial: other_trial }
    # let(:other_study_group) { create :substudy_group, trial: other_trial, position: 2 }
    # let(:other_compound_1) { create :substudy, trial: other_trial, substudy_group_id: other_compound_group.id }
    # let(:other_study1) { create :substudy, trial: other_trial, substudy_group_id: other_study_group.id, ancestry: other_compound_1.id }
    # let(:other_trial_site) { create :trial_site, :recruiting, trial: other_trial, substudy_id: other_study1.id }
    let(:other_trial_site) { create :trial_site, :recruiting, trial: other_trial }
    let(:other_subject) { create :subject, trial_site: other_trial_site, trial: other_trial }
    let(:other_workflow_run) { create :workflow_run, :status_completed, slot_visibility: other_slot_visibility, person_type: "Subject", person_id: other_subject.id, workflow: other_workflow, workflow_app: other_workflow_app }
    let(:other_sdf) { create :source_document_file, :file_kind_original, :with_date_performed, workflow_run: other_workflow_run, slot: other_slot }
    let(:other_user_role) { create :user_role, user: user, role: role, context: other_trial }

    # take this name from available models
    # /home/mmm/mddx/tap/app/services/report_runs/run_custom_report.rb
    let(:module_name) { :workflow_sdf_data }
    # take columns from model also
    let(:report_columns) do
      # {
      #   trial_name: { label: "Trial Name" },
      #   trial_abbreviation: { label: "Trial Abbreviation" },
      #   workflow_app_name: { label: "Workflow App Name" },
      #   workflow_name: { label: "Workflow Name" },
      #   workflow_version: { label: "Workflow Version" },
      #   workflow_run_id: { label: "Workflow Run ID" },
      #   workflow_run_date: { label: "Workflow Run Date" },
      #   workflow_run_status: { label: "Workflow Run Status" },
      #   # possible error ?
      #   workflow_outcome: { label: "Workflow Run Outcome" },
      #   workflow_run_person_site_name: { label: "Trial Site Name" },
      #   workflow_run_person_site_id: { label: "Trial Site Identifier" },
      #   workflow_run_person_type: { label: "Person Type" },
      #   workflow_run_person_identifier: { label: "Person Identifier" },
      #   sdf_category_name: { label: "Source Document Category" },
      #   sdf_slot_name: { label: "Source Document Name" },
      #   sdf_file_kind: { label: "Source Document Kind" },
      #   sdf_file_type: { label: "Source Document Type" },
      #   sdf_status: { label: "Source Document File Status" },
      #   sdf_created_at: { label: "Source Document File Created at" },
      #   sdf_updated_at: { label: "Source Document File Updated at" },
      #   sdf_turnaround_time: { label: "Source Document Slot Turnaround Time" }
      # }
      #
      # find resolve methods in
      # /home/mmm/mddx/tap/app/poro/custom_report
      #
      # instead of copy/pasted list above put this
      CustomReport::WorkflowSdfData::AVAILABLE_SDF_COLUMNS
    end
    # original
    # let(:columns) do
    #   report_columns.map.with_index do |(key, value), index|
    #     {
    #       identifier: key,
    #       display_conditions: [],
    #       type: "context_element",
    #       position: index + 1,
    #       label: value[:label]
    #     }
    #   end
    # end
    let(:columns) do
      context_data = report_columns.map.with_index do |(key, value), index|
        {
          identifier: key,
          display_conditions: [],
          type: "context_element",
          position: index + 1,
          label: value[:label]
        }
      end
      context_data_length = context_data.length
      context_data <<
        # {
        #   identifier: element.id,
        #   display_conditions: [],
        #   type: "custom_field",
        #   position: context_data_length + 1,
        #   label: element.name
        # } <<
        # move context data length by one
        {
          identifier: compound_group.id,
          display_conditions: [],
          type: "substudy_group",
          position: context_data_length + 1,
          label: compound_group.name
        } <<
        {
          identifier: study_group.id,
          display_conditions: [],
          type: "substudy_group",
          position: context_data_length + 2,
          label: study_group.name
        }
    end
    # filters not needed for initial template_structure because no filters being tested, if there is they will be filtering
    # out only specified for testing, in this case only workflow will be included so if changed trial to other_trial there will
    # be no results
    # let(:template_structure) { { module: module_name, filters: { workflow: [workflow.id] }, columns: columns } }
    let(:template_structure) { {module: module_name, columns: columns} }

    # let(:report_template) { create :report_template, template_structure: template_structure, processor_type: "custom_report", trial: trial }
    # let(:report_run) { create :report_run, :scheduled, report_template: report_template, created_by: user.id, mime_type: "csv" }
    # let(:service) { described_class.new(report_run) }
    # let(:content) { service.data[1..-1].map { |csv_line| Hash[service.data[0].zip(csv_line)] } }

    subject { service.call }

    context "as admin user" do
      let(:admin_user) { create :user, :admin }
      include_context "report run create csv custom" do
        let(:template_struct) { template_structure }
        let(:trial_of_report) { trial }
        let(:created_by_user) { admin_user.id }
        let(:roles_permitted_to_run_report) { [] }
        let(:res_filters) {}
      end
      before do
        sdf_1
        sdf_2
        sdf_3_1
        sdf_3_2
        # sdf.versions[0].update(event: "create", whodunnit: user.id, comment: "start")
        # sdf.update(status: :completed, updated_by: user.id)
        # sdf.versions[1].update(event: "complete", whodunnit: user.id, comment: "complete sdf")
        # sdf.update(status: :ready_for_signature, updated_by: user.id)
        other_sdf
      end
      it "should see all source documents for all Subjects in the trial" do
        is_expected.to be_truthy
        expect(report_run.reload.download_link.current_path).to match(/csv/)
        expect(content.size).to eq 16
        # content_test = content[1]
        # Report content
        csv_item_1 = {}
        csv_item_2 = {}
        csv_item_3 = {}
        csv_item_4 = {}
        subject_ids =
          content.map do |csv_row|
            csv_item_1 = csv_row if csv_row["Source Document File ID"] == sdf_1.id
            csv_item_2 = csv_row if csv_row["Source Document File ID"] == sdf_2.id
            csv_item_3 = csv_row if csv_row["Source Document File ID"] == sdf_3_1.id
            csv_item_4 = csv_row if csv_row["Source Document File ID"] == sdf_3_2.id
            # csv_item_1 = csv_row if csv_row["Person Identifier"] == subject_1.identifier && csv_row["Source Document Column"] == sdf_1.file_kind.humanize
            # csv_item_2 = csv_row if csv_row["Person Identifier"] == subject_2.identifier && csv_row["Source Document Column"] == sdf_2.file_kind.humanize
            # csv_item_3 = csv_row if csv_row["Person Identifier"] == subject_3_1.identifier && csv_row["Source Document Column"] == sdf_3_1.file_kind.humanize
            # csv_item_4 = csv_row if csv_row["Person Identifier"] == subject_3_2.identifier && csv_row["Source Document Column"] == sdf_3_2.file_kind.humanize
            csv_row["Person Identifier"]
          end
        expect(subject_ids).to match_array([subject_1.identifier] * 4 + [subject_2.identifier] * 4 +
                                               [subject_3_1.identifier] * 4 + [subject_3_2.identifier] * 4)
        expect(csv_item_1["Trial Name"]).to eq trial.name
        expect(csv_item_1["Trial Abbreviation"]).to eq trial.abbreviation
        expect(csv_item_1["Workflow App Name"]).to eq workflow_app.name
        expect(csv_item_1["Workflow Name"]).to eq workflow.name
        expect(csv_item_1["Workflow Version"]).to eq workflow.version_number
        expect(csv_item_1["Workflow Run ID"]).to eq workflow_run_1.id
        expect(csv_item_1["Workflow Run Date"]).to eq "#{workflow_run_1.event_date.strftime('%d-%^b-%Y')} UTC"
        expect(csv_item_1["Workflow Run Status"]).to eq workflow_run_1.status
        expect(csv_item_1["Workflow Run Outcome"]).to eq workflow_run_1.selected_outcome
        expect(csv_item_1["Trial Site Name"]).to eq workflow_run_1.person.trial_site.name
        # expect(csv_item_1["Trial Site Identifier"]).to eq workflow_run_1.person.trial_site.identifier
        expect(csv_item_1["Trial Site Identifier"]).to eq trial_site_1.identifier
        expect(csv_item_1["Person Type"]).to eq workflow_run_1.person_type
        expect(csv_item_1["Person Identifier"]).to eq workflow_run_1.person.identifier
        expect(csv_item_1["Source Document File ID"]).to eq sdf_1.id
        expect(csv_item_1["Source Document Category"]).to eq sdf_1.slot.category.name
        expect(csv_item_1["Source Document Name"]).to eq sdf_1.slot.name
        expect(csv_item_1["Source Document Column"]).to eq sdf_1.file_kind.humanize
        expect(csv_item_1["Source Document Type"]).to eq sdf_1.file_type.humanize
        expect(csv_item_1["Source Document File Status"]).to eq sdf_1.status.humanize
        expect(csv_item_1["Source Document File Created at"]).to eq "#{sdf_1.created_at.strftime('%d-%^b-%Y %H:%M:%S')} UTC"
        expect(csv_item_1["Source Document File Updated at"]).to eq "#{sdf_1.updated_at.strftime('%d-%^b-%Y %H:%M:%S')} UTC"
        expect(csv_item_1["Source Document Slot Turnaround Time"]).to eq TieredUnitFormatter.new.format(sdf_1.turnaround_time)

        expect(csv_item_1[study_group.name]).to eq study_1.name
        expect(csv_item_1[compound_group.name]).to eq compound_1.name
        # translated & not needed
        expect(csv_item_2["Source Document Column"]).to eq sdf_2.file_kind.humanize
        expect(csv_item_2["Source Document File Status"]).to eq sdf_2.status.humanize
        expect(csv_item_2["Source Document Type"]).to eq sdf_2.file_type.humanize
        # redacted & not available
        expect(csv_item_3["Source Document Column"]).to eq sdf_3_1.file_kind.humanize
        expect(csv_item_3["Source Document File Status"]).to eq sdf_3_1.status.humanize
        # completed & final
        expect(csv_item_4["Source Document Column"]).to eq sdf_3_2.file_kind.humanize
        expect(csv_item_4["Source Document File Status"]).to eq sdf_3_2.status.humanize
      end
    end # as admin user

    context "not admin user" do
      include_context "report run create csv custom" do
        let(:template_struct) { template_structure }
        let(:trial_of_report) { trial }
        let(:created_by_user) { user.id }
        let(:roles_permitted_to_run_report) { [role.id] }
        let(:res_filters) {}
      end
      before do
        # grants are in interface on admin/permissions page
        # create_grants account, role, workflow
        # create_grants account, role, workflow_app
        # create_grants account, role, slot
        # create_grants account, role, study_group
        # create_grants account, role, study_1
        # create_grants account, role, trial_site_1
        # create_grants account, role, subject_1
        # create_grants account, role, slot.category
        # create_grants account, role, category
        user_role
        other_sdf
      end

      # no special set beyond setting trial in include_context
      context "user running the report can index Subjects on trial multiple sdfs" do
        let(:slot_second) { create :source_document_slot, category: category, workflow: workflow }
        let(:slot_visibility_second) { {slot.id.to_s => "visible", slot_second.id.to_s => "visible"} }
        let(:workflow_run_second_slot) { create :workflow_run, :with_selected_outcome, :with_data, :status_completed, slot_visibility: slot_visibility_second, person_type: "Subject", person_id: subject_1.id, workflow: workflow, workflow_app: workflow_app }

        # added file_index attribute (check what is it used for)
        # let(:sdf_1_main_original_completed) { create :source_document_file, :file_type_main, :file_kind_original, :status_completed, :with_date_performed, file_index: 0,  workflow_run: workflow_run_second_slot, slot: slot }
        # let(:sdf_1_main_translated_not_needed) { create :source_document_file, :file_type_main, :file_kind_translated, :status_not_needed, :with_date_performed, file_index: 0, workflow_run: workflow_run_second_slot, slot: slot }
        # let(:sdf_1_main_redacted_not_available) { create :source_document_file, :file_type_main, :file_kind_redacted, :status_not_available, :with_date_performed, file_index: 0, workflow_run: workflow_run_second_slot, slot: slot }
        # let(:sdf_1_main_final_completed) { create :source_document_file, :file_type_main, :file_kind_final, :status_completed, :with_date_performed, file_index: 0, workflow_run: workflow_run_second_slot, slot: slot }
        # let(:sdf_1_support_original_upload_requested) { create :source_document_file, :file_type_support, :file_kind_original, :status_upload_requested, :with_date_performed, file_index: 1, workflow_run: workflow_run_second_slot, slot: slot }
        #
        # let(:sdf_1b_main_original_ready_for_signature) { create :source_document_file, :status_ready_for_signature, :file_type_main, :file_kind_original, :with_date_performed, file_index: 0, workflow_run: workflow_run_second_slot, slot: slot_second }
        # let(:sdf_1b_support_original_upload_processing) { create :source_document_file, :status_upload_processing, :file_type_support, :file_kind_original, :with_date_performed, file_index: 1, workflow_run: workflow_run_second_slot, slot: slot_second }
        # let(:sdf_1b_support_original_failed) { create :source_document_file, :status_failed, :file_type_support, :file_kind_original, :with_date_performed, file_index: 2, workflow_run: workflow_run_second_slot, slot: slot_second }

        let(:sdf_1_main_original_completed) { create :source_document_file, :file_type_main, :file_kind_original, :status_completed, :with_date_performed,  workflow_run: workflow_run_second_slot, slot: slot }
        let(:sdf_1_main_translated_not_needed) { create :source_document_file, :file_type_main, :file_kind_translated, :status_not_needed, :with_date_performed, workflow_run: workflow_run_second_slot, slot: slot }
        let(:sdf_1_main_redacted_not_available) { create :source_document_file, :file_type_main, :file_kind_redacted, :status_not_available, :with_date_performed, workflow_run: workflow_run_second_slot, slot: slot }
        let(:sdf_1_main_final_completed) { create :source_document_file, :file_type_main, :file_kind_final, :status_completed, :with_date_performed, workflow_run: workflow_run_second_slot, slot: slot }
        let(:sdf_1_support_original_upload_requested) { create :source_document_file, :file_type_support, :file_kind_original, :status_upload_requested, :with_date_performed, workflow_run: workflow_run_second_slot, slot: slot }

        let(:sdf_1b_main_original_ready_for_signature) { create :source_document_file, :status_ready_for_signature, :file_type_main, :file_kind_original, :with_date_performed, workflow_run: workflow_run_second_slot, slot: slot_second }
        let(:sdf_1b_support_original_upload_processing) { create :source_document_file, :status_upload_processing, :file_type_support, :file_kind_original, :with_date_performed, workflow_run: workflow_run_second_slot, slot: slot_second }
        let(:sdf_1b_support_original_failed) { create :source_document_file, :status_failed, :file_type_support, :file_kind_original, :with_date_performed, workflow_run: workflow_run_second_slot, slot: slot_second }

        before do
          create_grants account, role, workflow
          create_grants account, role, study_1
          create_grants account, role, subject_1

          sdf_1_main_original_completed
          sdf_1_main_translated_not_needed
          sdf_1_main_redacted_not_available
          sdf_1_main_final_completed
          sdf_1_support_original_upload_requested

          sdf_1b_main_original_ready_for_signature
          sdf_1b_support_original_upload_processing
          sdf_1b_support_original_failed
        end
        it "should see all source documents for all Subjects in the trial" do
          is_expected.to be_truthy
          expect(report_run.reload.download_link.current_path).to match(/csv/)
          expect(content.size).to eq 17

          content_array = []
          content.each do |row|
            # if row["Source Document File Created at"] != nil && row["Workflow Run ID"] == workflow_run_second_slot.id
            #   small_array = [row["Source Document Type"], row["Source Document Column"], row["Source Document File Status"], row["Source Document File Created at"], row["Source Document Name"]]
            if row["Source Document File ID"] != nil
              small_array = [row["Source Document File ID"], row["Source Document Type"], row["Source Document Column"], row["Source Document File Status"], row["Source Document File Created at"], row["Source Document Name"]]
              content_array << small_array
            end
          end
          # sdf_items = []
          # sdf_items.push(sdf_1_main_original_completed, sdf_1_main_translated_not_needed, sdf_1_main_redacted_not_available, sdf_1_main_final_completed, sdf_1_support_original_upload_requested, sdf_1_support_translated_not_needed, sdf_1_support_redacted_not_available, sdf_1_support_final_ready_for_signature, sdf_1b_main_original_ready_for_signature, sdf_1b_support_original_upload_processing, sdf_1b_support_original_failed)
          sdf_items = [sdf_1_main_original_completed, sdf_1_main_translated_not_needed, sdf_1_main_redacted_not_available, sdf_1_main_final_completed, sdf_1_support_original_upload_requested, sdf_1b_main_original_ready_for_signature, sdf_1b_support_original_upload_processing, sdf_1b_support_original_failed]
          expected_array = []
          sdf_items.each do |sdf|
            small_array = [sdf.id, sdf.file_type.humanize, sdf.file_kind.humanize, sdf.status.humanize, "#{sdf.created_at.strftime('%d-%^b-%Y %H:%M:%S')} UTC", sdf.slot.name]
            expected_array << small_array
          end
          expect(content_array).to match_array(expected_array)

          # expect(csv_item_2["Source Document Type"]).to eq sdf_1_main_translated_not_needed.file_type.humanize
          # expect(csv_item_2["Source Document Column"]).to eq sdf_1_main_translated_not_needed.file_kind.humanize
          # expect(csv_item_2["Source Document File Status"]).to eq sdf_1_main_translated_not_needed.status.humanize
          #
          # expect(csv_item_3["Source Document Type"]).to eq sdf_1_main_redacted_not_available.file_type.humanize
          # expect(csv_item_3["Source Document Column"]).to eq sdf_1_main_redacted_not_available.file_kind.humanize
          # expect(csv_item_3["Source Document File Status"]).to eq sdf_1_main_redacted_not_available.status.humanize
          #
          # expect(csv_item_4["Source Document Type"]).to eq sdf_1_main_final_completed.file_type.humanize
          # expect(csv_item_4["Source Document Column"]).to eq sdf_1_main_final_completed.file_kind.humanize
          # expect(csv_item_4["Source Document File Status"]).to eq sdf_1_main_final_completed.status.humanize
          #
          # expect(csv_item_5["Source Document Type"]).to eq sdf_1_support_original_upload_requested.file_type.humanize
          # expect(csv_item_5["Source Document Column"]).to eq sdf_1_support_original_upload_requested.file_kind.humanize
          # expect(csv_item_5["Source Document File Status"]).to eq sdf_1_support_original_upload_requested.status.humanize
          #
          # expect(csv_item_6["Source Document Type"]).to eq sdf_1_support_translated_not_needed.file_type.humanize
          # expect(csv_item_6["Source Document Column"]).to eq sdf_1_support_translated_not_needed.file_kind.humanize
          # expect(csv_item_6["Source Document File Status"]).to eq sdf_1_support_translated_not_needed.status.humanize
          #
          # expect(csv_item_7["Source Document Type"]).to eq sdf_1_support_redacted_not_available.file_type.humanize
          # expect(csv_item_7["Source Document Column"]).to eq sdf_1_support_redacted_not_available.file_kind.humanize
          # expect(csv_item_7["Source Document File Status"]).to eq sdf_1_support_redacted_not_available.status.humanize
          #
          # expect(csv_item_8["Source Document Type"]).to eq sdf_1_support_final_ready_for_signature.file_type.humanize
          # expect(csv_item_8["Source Document Column"]).to eq sdf_1_support_final_ready_for_signature.file_kind.humanize
          # expect(csv_item_8["Source Document File Status"]).to eq sdf_1_support_final_ready_for_signature.status.humanize
          #
          # expect(csv_item_9["Source Document Type"]).to eq sdf_1b_main_original_ready_for_signature.file_type.humanize
          # expect(csv_item_9["Source Document Column"]).to eq sdf_1b_main_original_ready_for_signature.file_kind.humanize
          # expect(csv_item_9["Source Document File Status"]).to eq sdf_1b_main_original_ready_for_signature.status.humanize
          #
          # expect(csv_item_10["Source Document Type"]).to eq sdf_1b_support_original_upload_processing.file_type.humanize
          # expect(csv_item_10["Source Document Column"]).to eq sdf_1b_support_original_upload_processing.file_kind.humanize
          # expect(csv_item_10["Source Document File Status"]).to eq sdf_1b_support_original_upload_processing.status.humanize
          #
          # expect(csv_item_11["Source Document Type"]).to eq sdf_1b_support_original_failed.file_type.humanize
          # expect(csv_item_11["Source Document Column"]).to eq sdf_1b_support_original_failed.file_kind.humanize
          # expect(csv_item_11["Source Document File Status"]).to eq sdf_1b_support_original_failed.status.humanize
        end
      end

      context "full trial data" do
        before do
          # grants & roles are set on admin management / permissions
          create_grants account, role, workflow
          create_grants account, role, study_1
          create_grants account, role, subject_1
          sdf_1
          sdf_2
          sdf_3_1
          sdf_3_2
        end

        context "subject access" do

          # no special set beyond setting trial in include_context in interface
          context "user running the report can index Subjects on trial one row detailed" do
            it do
              is_expected.to be_truthy
              expect(report_run.reload.download_link.current_path).to match(/csv/)
              expect(content.size).to eq 16
              # Report content
              csv_item_1 = {}
              # csv_item_2 = {}
              # csv_item_3 = {}
              # csv_item_4 = {}
              # csv_item_5 = {}
              # csv_item_6 = {}
              # csv_item_7 = {}
              # csv_item_8 = {}
              #
              # csv_item_9 = {}
              # csv_item_10 = {}
              # csv_item_11 = {}
              subject_ids =
                content.map do |csv_row|
                  # csv_item_1 = csv_row if csv_row["Person Identifier"] == subject_1.identifier && csv_row["Source Document Type"] == sdf_1.file_type.humanize && csv_row["Source Document Column"] == sdf_1.file_kind.humanize && csv_row["Source Document File Created at"] != nil && csv_row["Source Document Name"] == sdf_1.slot.name && csv_row["Source Document File Status"] == sdf_1.status.humanize # && csv_row["Workflow Run ID"] == workflow_run_second_slot.id
                  csv_item_1 = csv_row if csv_row["Source Document File ID"] == sdf_1.id
                  # csv_item_2 = csv_row if csv_row["Source Document Type"] == sdf_1_main_translated_not_needed.file_type.humanize && csv_row["Source Document Column"] == sdf_1_main_translated_not_needed.file_kind.humanize && csv_row["Source Document File Created at"] != nil && csv_row["Source Document Name"] == sdf_1_main_translated_not_needed.slot.name && csv_row["Source Document File Status"] == sdf_1_main_translated_not_needed.status.humanize
                  # csv_item_3 = csv_row if csv_row["Source Document Type"] == sdf_1_main_redacted_not_available.file_type.humanize && csv_row["Source Document Column"] == sdf_1_main_redacted_not_available.file_kind.humanize && csv_row["Source Document File Created at"] != nil && csv_row["Source Document Name"] == sdf_1_main_redacted_not_available.slot.name && csv_row["Source Document File Status"] == sdf_1_main_redacted_not_available.status.humanize
                  # csv_item_4 = csv_row if csv_row["Source Document Type"] == sdf_1_main_final_completed.file_type.humanize && csv_row["Source Document Column"] == sdf_1_main_final_completed.file_kind.humanize && csv_row["Source Document File Created at"] != nil && csv_row["Source Document Name"] == sdf_1_main_final_completed.slot.name && csv_row["Source Document File Status"] == sdf_1_main_final_completed.status.humanize
                  # csv_item_5 = csv_row if csv_row["Source Document Type"] == sdf_1_support_original_upload_requested.file_type.humanize && csv_row["Source Document Column"] == sdf_1_support_original_upload_requested.file_kind.humanize && csv_row["Source Document File Created at"] != nil && csv_row["Source Document Name"] == sdf_1_support_original_upload_requested.slot.name && csv_row["Source Document File Status"] == sdf_1_support_original_upload_requested.status.humanize
                  # csv_item_6 = csv_row if csv_row["Source Document Type"] == sdf_1_support_translated_not_needed.file_type.humanize && csv_row["Source Document Column"] == sdf_1_support_translated_not_needed.file_kind.humanize && csv_row["Source Document File Created at"] != nil && csv_row["Source Document Name"] == sdf_1_support_translated_not_needed.slot.name && csv_row["Source Document File Status"] == sdf_1_support_translated_not_needed.status.humanize
                  # csv_item_7 = csv_row if csv_row["Source Document Type"] == sdf_1_support_redacted_not_available.file_type.humanize && csv_row["Source Document Column"] == sdf_1_support_redacted_not_available.file_kind.humanize && csv_row["Source Document File Created at"] != nil && csv_row["Source Document Name"] == sdf_1_support_redacted_not_available.slot.name && csv_row["Source Document File Status"] == sdf_1_support_redacted_not_available.status.humanize
                  # csv_item_8 = csv_row if csv_row["Source Document Type"] == sdf_1_support_final_ready_for_signature.file_type.humanize && csv_row["Source Document Column"] == sdf_1_support_final_ready_for_signature.file_kind.humanize && csv_row["Source Document File Created at"] != nil && csv_row["Source Document Name"] == sdf_1_support_final_ready_for_signature.slot.name && csv_row["Source Document File Status"] == sdf_1_support_final_ready_for_signature.status.humanize
                  #
                  # csv_item_9 = csv_row if csv_row["Source Document Type"] == sdf_1b_main_original_ready_for_signature.file_type.humanize && csv_row["Source Document Column"] == sdf_1b_main_original_ready_for_signature.file_kind.humanize && csv_row["Source Document File Created at"] != nil && csv_row["Source Document Name"] == sdf_1b_main_original_ready_for_signature.slot.name && csv_row["Source Document File Status"] == sdf_1b_main_original_ready_for_signature.status.humanize
                  # csv_item_10 = csv_row if csv_row["Source Document Type"] == sdf_1b_support_original_upload_processing.file_type.humanize && csv_row["Source Document Column"] == sdf_1b_support_original_upload_processing.file_kind.humanize && csv_row["Source Document File Created at"] != nil && csv_row["Source Document Name"] == sdf_1b_support_original_upload_processing.slot.name && csv_row["Source Document File Status"] == sdf_1b_support_original_upload_processing.status.humanize
                  # csv_item_11 = csv_row if csv_row["Source Document Type"] == sdf_1b_support_original_failed.file_type.humanize && csv_row["Source Document Column"] == sdf_1b_support_original_failed.file_kind.humanize && csv_row["Source Document File Created at"] != nil && csv_row["Source Document Name"] == sdf_1b_support_original_failed.slot.name && csv_row["Source Document File Status"] == sdf_1b_support_original_failed.status.humanize
                  csv_row["Person Identifier"]
                end
              expect(subject_ids).to match_array([subject_1.identifier] * 4 + [subject_2.identifier] * 4 +
                                                     [subject_3_1.identifier] * 4 + [subject_3_2.identifier] * 4)
              expect(csv_item_1["Trial Name"]).to eq trial.name
              expect(csv_item_1["Trial Abbreviation"]).to eq trial.abbreviation
              expect(csv_item_1["Workflow App Name"]).to eq workflow_app.name
              expect(csv_item_1["Workflow Name"]).to eq workflow.name
              expect(csv_item_1["Workflow Version"]).to eq workflow.version_number
              expect(csv_item_1["Workflow Run ID"]).to eq workflow_run_1.id
              expect(csv_item_1["Workflow Run Date"]).to eq "#{workflow_run_1.event_date.strftime('%d-%^b-%Y')} UTC"
              expect(csv_item_1["Workflow Run Status"]).to eq workflow_run_1.status
              expect(csv_item_1["Workflow Run Outcome"]).to eq workflow_run_1.selected_outcome
              expect(csv_item_1["Trial Site Name"]).to eq workflow_run_1.person.trial_site.name
              # expect(csv_item_1["Trial Site Identifier"]).to eq workflow_run_1.person.trial_site.identifier
              expect(csv_item_1["Trial Site Identifier"]).to eq trial_site_1.identifier
              expect(csv_item_1["Person Type"]).to eq workflow_run_1.person_type
              expect(csv_item_1["Person Identifier"]).to eq workflow_run_1.person.identifier
              expect(csv_item_1["Source Document File ID"]).to eq sdf_1.id
              expect(csv_item_1["Source Document Category"]).to eq sdf_1.slot.category.name
              expect(csv_item_1["Source Document Name"]).to eq sdf_1.slot.name
              expect(csv_item_1["Source Document Column"]).to eq sdf_1.file_kind.humanize
              expect(csv_item_1["Source Document Type"]).to eq sdf_1.file_type.humanize
              expect(csv_item_1["Source Document File Status"]).to eq sdf_1.status.humanize
              expect(csv_item_1["Source Document File Created at"]).to eq "#{sdf_1.created_at.strftime('%d-%^b-%Y %H:%M:%S')} UTC"
              expect(csv_item_1["Source Document File Updated at"]).to eq "#{sdf_1.updated_at.strftime('%d-%^b-%Y %H:%M:%S')} UTC"
              expect(csv_item_1["Source Document Slot Turnaround Time"]).to eq TieredUnitFormatter.new.format(sdf_1.turnaround_time)

              expect(csv_item_1[study_group.name]).to eq study_1.name
              expect(csv_item_1[compound_group.name]).to eq compound_1.name
            end
          end

          # set during grants creation
          context "user running the report can index Subjects on his site" do
            let(:user_trial_site) { create :user_trial_site, user: user, trial_site: trial_site_1 }
            before do
              create_grants account, role, subject_1, ["show"], trial_site_id: "user_trial_sites_ids"
              user_trial_site
            end
            it "should see all source documents for Subjects on his Trial Site" do
              is_expected.to be_truthy
              expect(report_run.reload.download_link.current_path).to match(/csv/)
              expect(content.size).to eq 4
              subject_ids = content.map do |csv_row|
                csv_row["Person Identifier"]
              end
              expect(subject_ids).to match_array([subject_1.identifier] * 4)
            end
          end

          context "user running the report can index Subjects in his study" do
            before do
              create_grants account, role, subject_1, ["show"], trial_site_id: "user_substudy_trial_site_ids"
            end

            context "when on Compound" do
              let(:user_substudy) { create :user_substudy, user: user, substudy: compound_1 }
              before do
                user_substudy
              end
              it "should see all source documents for Subjects in his Compound" do
                is_expected.to be_truthy
                expect(report_run.reload.download_link.current_path).to match(/csv/)
                expect(content.size).to eq 8
                subject_ids = content.map do |csv_row|
                  csv_row["Person Identifier"]
                end
                expect(subject_ids).to match_array([subject_1.identifier] * 4 + [subject_2.identifier] * 4)
              end
            end

            context "when on Study" do
              let(:user_substudy) { create :user_substudy, user: user, substudy: study_1 }
              before do
                user_substudy
              end
              it "should see all source documents for Subjects in his Study" do
                is_expected.to be_truthy
                expect(report_run.reload.download_link.current_path).to match(/csv/)
                expect(content.size).to eq 4
                expect(content.first["Person Identifier"]).to eq subject_1.identifier
              end
            end

          end # study

        end # subject access

        context "with filter" do

          # to be setted during report creation
          context "with wf_app filters" do
            # and both workflows aps but later filter out only one
            let(:wf_app_filter_workflow) { create :workflow, :status_force_approved, preferences: preferences, sd_permissions: sd_permissions, trial: trial, version_number: 1, workflow_apps: [workflow_app, wf_app_filter_workflow_app] }
            let(:wf_app_filter_workflow_app) { create :workflow_app, trial: trial }
            let(:wf_app_filter_category) { create :source_document_category, workflow: wf_app_filter_workflow }
            let(:wf_app_filter_slot) { create :source_document_slot, category: wf_app_filter_category, workflow: wf_app_filter_workflow }
            let(:wf_app_filter_slot_visibility) { {wf_app_filter_slot.id.to_s => "visible"} }
            let(:wf_app_filter_workflow_run) { create :workflow_run, :status_in_progress, slot_visibility: wf_app_filter_slot_visibility, person_type: "Subject", person_id: subject_1.id, workflow: wf_app_filter_workflow, workflow_app: wf_app_filter_workflow_app }
            # filter out only second workflow app
            let(:wf_app_filter_template_structure) { {module: module_name, columns: columns, filters: {workflow_app: [wf_app_filter_workflow_app.id]}} }
            let(:wf_app_filter_sdf) { create :source_document_file, :file_kind_original, :with_date_performed, workflow_run: wf_app_filter_workflow_run, slot: wf_app_filter_slot }

            include_context "report run create csv custom" do
              let(:template_struct) { wf_app_filter_template_structure }
              let(:trial_of_report) { trial }
              let(:created_by_user) { user.id }
              let(:roles_permitted_to_run_report) { [role.id] }
              let(:res_filters) {}
            end
            before { wf_app_filter_sdf }
            it "should show only source documents from the selected wf_app" do
              is_expected.to be_truthy
              expect(report_run.reload.download_link.current_path).to match(/csv/)
              expect(content.size).to eq 4
              csv_item = {}
              content.map do |csv_row|
                csv_item = csv_row if csv_row["Source Document File ID"] == wf_app_filter_sdf.id
              end
              # Report content
              expect(csv_item["Person Identifier"]).to eq subject_1.identifier
              expect(csv_item["Workflow Run ID"]).to eq wf_app_filter_workflow_run.id
              expect(csv_item["Workflow App Name"]).to eq wf_app_filter_workflow_app.name
              expect(csv_item["Source Document Name"]).to eq wf_app_filter_sdf.slot.name
              expect(csv_item["Source Document File ID"]).to eq wf_app_filter_sdf.id
            end
          end

          # to be setted during report creation
          context "with wf filters" do
            let(:wf_filter_workflow) { create :workflow, :status_force_approved, preferences: preferences, sd_permissions: sd_permissions, trial: trial, version_number: 1, workflow_apps: [wf_filter_workflow_app] }
            let(:wf_filter_workflow_app) { create :workflow_app, trial: trial }
            let(:wf_filter_category) { create :source_document_category, workflow: wf_filter_workflow }
            let(:wf_filter_slot) { create :source_document_slot, category: wf_filter_category, workflow: wf_filter_workflow }
            let(:wf_filter_slot_visibility) { {wf_filter_slot.id.to_s => "visible"} }
            let(:wf_filter_workflow_run) { create :workflow_run, :status_in_progress, slot_visibility: wf_filter_slot_visibility, person_type: "Subject", person_id: subject_1.id, workflow: wf_filter_workflow, workflow_app: wf_filter_workflow_app }
            # filter out only second workflow (default worflow is not included)
            let(:wf_filter_template_structure) { {module: module_name, columns: columns, filters: {workflow: [wf_filter_workflow.id]}} }
            let(:wf_filter_sdf) { create :source_document_file, :file_kind_original, :with_date_performed, workflow_run: wf_filter_workflow_run, slot: wf_filter_slot }

            include_context "report run create csv custom" do
              let(:template_struct) { wf_filter_template_structure }
              let(:trial_of_report) { trial }
              let(:created_by_user) { user.id }
              let(:roles_permitted_to_run_report) { [role.id] }
              let(:res_filters) {}
            end
            before { wf_filter_sdf }
            it "should show only source documents of the selected wf" do
              is_expected.to be_truthy
              expect(report_run.reload.download_link.current_path).to match(/csv/)
              expect(content.size).to eq 4
              csv_item = {}
              content.map do |csv_row|
                csv_item = csv_row if csv_row["Source Document File ID"] == wf_filter_sdf.id
              end
              # Report content
              expect(csv_item["Person Identifier"]).to eq subject_1.identifier
              expect(csv_item["Workflow Run ID"]).to eq wf_filter_workflow_run.id
              expect(csv_item["Workflow Name"]).to eq wf_filter_workflow.name
              expect(csv_item["Source Document Name"]).to eq wf_filter_sdf.slot.name
              expect(csv_item["Source Document File ID"]).to eq wf_filter_sdf.id
            end
          end

          # to be setted during report running, if trial_layer_mode is set to true in trial_settings
          context "substudy filter" do

            context "with compound filter" do
              include_context "report run create csv custom" do
                let(:template_struct) { template_structure }
                let(:trial_of_report) { trial }
                let(:created_by_user) { user.id }
                let(:roles_permitted_to_run_report) { [role.id] }
                let(:res_filters) { {substudy: [compound_1.id]} }
              end
              it "should show only source documents for Subjects in the selected Compound" do
                is_expected.to be_truthy
                expect(report_run.reload.download_link.current_path).to match(/csv/)
                expect(content.size).to eq 8
                subject_ids = content.map do |csv_row|
                  csv_row["Person Identifier"]
                end
                expect(subject_ids).to match_array([subject_1.identifier] * 4 + [subject_2.identifier] * 4)
              end
            end

            context "when study" do
              include_context "report run create csv custom" do
                let(:template_struct) { template_structure }
                let(:trial_of_report) { trial }
                let(:created_by_user) { user.id }
                let(:roles_permitted_to_run_report) { [role.id] }
                let(:res_filters) { {substudy: [study_1.id]} }
              end
              it "should show only source documents for Subjects in the selected Study" do
                is_expected.to be_truthy
                expect(report_run.reload.download_link.current_path).to match(/csv/)
                expect(content.size).to eq 4
                subject_ids = content.map do |csv_row|
                  csv_row["Person Identifier"]
                end
                expect(subject_ids).to match_array([subject_1.identifier] * 4)
              end
            end

          end

          # to be setted during report running
          context "site filter" do
            include_context "report run create csv custom" do
              let(:template_struct) { template_structure }
              let(:trial_of_report) { trial }
              let(:created_by_user) { user.id }
              let(:roles_permitted_to_run_report) { [role.id] }
              let(:res_filters) { {trial_site: [trial_site_1.id]} }
            end
            it "should show only source documents for Subjects on the selected Trial Site" do
              is_expected.to be_truthy
              expect(report_run.reload.download_link.current_path).to match(/csv/)
              expect(content.size).to eq 4
              subject_ids = content.map do |csv_row|
                csv_row["Person Identifier"]
              end
              expect(subject_ids).to match_array([subject_1.identifier] * 4)
            end
          end

          # to be setted during report running
          context "subject filter" do
            include_context "report run create csv custom" do
              let(:template_struct) { template_structure }
              let(:trial_of_report) { trial }
              let(:created_by_user) { user.id }
              let(:roles_permitted_to_run_report) { [role.id] }
              let(:res_filters) { {subject: [subject_1.id.to_s, subject_3_2.id.to_s]} }
            end
            it "should show only source documents for the selected Subjects" do
              is_expected.to be_truthy
              expect(report_run.reload.download_link.current_path).to match(/csv/)
              expect(content.size).to eq 8
              subject_ids = content.map do |csv_row|
                csv_row["Person Identifier"]
              end
              expect(subject_ids).to match_array([subject_3_2.identifier] * 4 + [subject_1.identifier] * 4)
            end
          end

        end # with filter

      end # full trial data

      context "basic trial data" do
        include_context "report run create csv custom" do
          let(:template_struct) { template_structure }
          let(:trial_of_report) { trial }
          let(:created_by_user) { user.id }
          let(:roles_permitted_to_run_report) { [role.id] }
          let(:res_filters) {}
        end
        before do
          sdf_1
        end

        context "failing tests" do

          context "user running the report can not index subjects" do
            # missing subject grant
            before do
              create_grants account, role, workflow
              create_grants account, role, study_1
            end
            it "should not see a single sdf" do
              is_expected.to be_truthy
              expect(report_run.reload.download_link.current_path).to match(/csv/)
              expect(content.size).to eq 0
            end
          end

          context "user running the report can not index workflow" do
            # missing workflow grant
            before do
              create_grants account, role, subject_1
              create_grants account, role, study_1
            end
            it "should not see a single sdf" do
              is_expected.to be_truthy
              expect(report_run.reload.download_link.current_path).to match(/csv/)
              expect(content.size).to eq 0
            end
          end

          context "columns for substudy groups should be empty in the report" do
            # missing substudies grant
            before do
              create_grants account, role, subject_1
              create_grants account, role, workflow
            end
            it "should not see a single sdf" do
              is_expected.to be_truthy
              expect(report_run.reload.download_link.current_path).to match(/csv/)
              expect(content.size).to eq 4
              # Report content
              content.each do |csv_row|
                expect(csv_row[compound_group.name]).to eq ""
                expect(csv_row[study_group.name]).to eq ""
              end
            end
          end

        end # failing tests

        context "basic trial data grants" do
          before do
            create_grants account, role, workflow
            create_grants account, role, study_1
            create_grants account, role, subject_1
          end

          context "user running the report can index Subjects on trial ghost testing" do
            it "should see all source documents for all Subjects in the trial" do
              is_expected.to be_truthy
              expect(report_run.reload.download_link.current_path).to match(/csv/)
              expect(content.size).to eq 4
              # content_test = content[1]
              # Report content
              csv_item_1 = {}
              csv_item_2 = {}
              csv_item_3 = {}
              csv_item_4 = {}
              subject_ids =
                content.map do |csv_row|
                  # csv_item_1 = csv_row if csv_row["Person Identifier"] == subject_1.identifier && csv_row["Source Document Column"] == "Original"
                  # csv_item_2 = csv_row if csv_row["Person Identifier"] == subject_1.identifier && csv_row["Source Document Column"] == "Translated"
                  # csv_item_3 = csv_row if csv_row["Person Identifier"] == subject_1.identifier && csv_row["Source Document Column"] == "Redacted"
                  # csv_item_4 = csv_row if csv_row["Person Identifier"] == subject_1.identifier && csv_row["Source Document Column"] == "Final"
                  csv_item_1 = csv_row if csv_row["Source Document Column"] == "Original"
                  csv_item_2 = csv_row if csv_row["Source Document Column"] == "Translated"
                  csv_item_3 = csv_row if csv_row["Source Document Column"] == "Redacted"
                  csv_item_4 = csv_row if csv_row["Source Document Column"] == "Final"
                  csv_row["Person Identifier"]
                end
              expect(subject_ids).to match_array([subject_1.identifier] * 4)
              # original
              expect(csv_item_1["Source Document Column"]).to eq sdf_1.file_kind.humanize
              expect(csv_item_1["Source Document File Status"]).to eq sdf_1.status.humanize
              # translated
              expect(csv_item_2["Trial Name"]).to eq trial.name
              expect(csv_item_2["Trial Abbreviation"]).to eq trial.abbreviation
              expect(csv_item_2["Workflow App Name"]).to eq workflow_app.name
              expect(csv_item_2["Workflow Name"]).to eq workflow.name
              expect(csv_item_2["Workflow Version"]).to eq workflow.version_number
              expect(csv_item_2["Workflow Run ID"]).to eq workflow_run_1.id
              expect(csv_item_2["Workflow Run Date"]).to eq "#{workflow_run_1.event_date.strftime('%d-%^b-%Y')} UTC"
              expect(csv_item_2["Workflow Run Status"]).to eq workflow_run_1.status
              expect(csv_item_2["Workflow Run Outcome"]).to eq workflow_run_1.selected_outcome
              expect(csv_item_2["Trial Site Name"]).to eq workflow_run_1.person.trial_site.name
              # expect(csv_item_2["Trial Site Identifier"]).to eq workflow_run_1.person.trial_site.identifier
              expect(csv_item_2["Trial Site Identifier"]).to eq trial_site_1.identifier
              expect(csv_item_2["Person Type"]).to eq workflow_run_1.person_type
              expect(csv_item_2["Person Identifier"]).to eq workflow_run_1.person.identifier
              expect(csv_item_2["Source Document File ID"]).to eq nil
              expect(csv_item_2["Source Document Category"]).to eq sdf_1.slot.category.name
              expect(csv_item_2["Source Document Name"]).to eq sdf_1.slot.name
              expect(csv_item_2["Source Document Column"]).to eq "Translated"
              expect(csv_item_2["Source Document Type"]).to eq sdf_1.file_type.humanize
              expect(csv_item_2["Source Document File Status"]).to eq "Created"
              expect(csv_item_2["Source Document File Created at"]).to eq nil
              expect(csv_item_2["Source Document File Updated at"]).to eq nil
              expect(csv_item_2["Source Document Slot Turnaround Time"]).to eq TieredUnitFormatter.new.format(sdf_1.turnaround_time)

              expect(csv_item_2[study_group.name]).to eq study_1.name
              expect(csv_item_2[compound_group.name]).to eq compound_1.name
              # redacted
              expect(csv_item_3["Source Document Column"]).to eq "Redacted"
              expect(csv_item_3["Source Document File Status"]).to eq "Created"
              # final
              expect(csv_item_4["Source Document Column"]).to eq "Final"
              expect(csv_item_4["Source Document File Status"]).to eq "Created"
            end
          end

          context "with filter" do

=begin
            context "created from-to filter" do
              # let(:sdf_alt) { create :source_document_file, :file_kind_original, :with_date_performed, workflow_run: workflow_run1, slot: slot, created_at: Time.now - 2.days }
              let(:sdf_alt) { create :source_document_file, :file_kind_original, :with_date_performed, workflow_run: workflow_run1, slot: slot, created_at: Time.now - 1000 }
              include_context "create csv custom report run" do
                let(:template_struct) { template_structure }
                let(:trial_of_report) { trial }
                let(:created_by_user) { user.id }
                let(:roles_permitted_to_run_report) { [role.id] }
                # let(:res_filters) { {created_from: (Time.now - 3.days).strftime("%F"), created_to: (Time.now - 1.days).strftime("%F")} }
                # Time.now returns current time / +1000 add 1000 seconds to that time
                let(:res_filters) { { created_from: (Time.now - 2000), created_to: (Time.now) } }
              end
              before do
                sdf_alt
              end
              it "should show only source documents that were created in the selected period" do
                is_expected.to be_truthy
                expect(report_run.reload.download_link.current_path).to match(/csv/)
                expect(content.size).to eq 5
                expect(content.first["Person Identifier"]).to eq subject_1.identifier
                expect(content.first["Source Document Name"]).to eq sdf_alt.slot.name
              end
            end

            context "updated from-to filter" do
              let(:sdf_alt) { create :source_document_file, :file_kind_original, :with_date_performed, workflow_run: workflow_run1, slot: slot, created_at: Time.now - 2000, updated_at: Time.now - 1000 }
              include_context "create csv custom report run" do
                let(:template_struct) { template_structure }
                let(:trial_of_report) { trial }
                let(:created_by_user) { user.id }
                let(:roles_permitted_to_run_report) { [role.id] }
                let(:res_filters) { {updated_from: (Time.now - 2000), updated_to: (Time.now) } }
              end
              before do
                sdf_alt
              end
              it "should show only source documents that were updated in the selected period" do
                is_expected.to be_truthy
                expect(report_run.reload.download_link.current_path).to match(/csv/)
                expect(content.size).to eq 5
                expect(content.first["Person Identifier"]).to eq subject_1.identifier
                expect(content.first["Source Document Name"]).to eq sdf_alt.slot.name
              end
            end
=end

            # to be setted during report running
            context "subject status filter" do
              let(:status_filter_subject_invalid) { create :subject, trial_site: trial_site_1, trial: trial, status: "invalid" }
              let(:status_filter_subject_dropout) { create :subject, trial_site: trial_site_1, trial: trial, status: "dropout", dropout_reason: "terminated" }
              let(:status_filter_workflow_run_invalid) { create :workflow_run, :status_completed, slot_visibility: slot_visibility, person_type: "Subject", person_id: status_filter_subject_invalid.id, workflow: workflow, workflow_app: workflow_app }
              let(:status_filter_workflow_run_dropout) { create :workflow_run, :status_completed, slot_visibility: slot_visibility, person_type: "Subject", person_id: status_filter_subject_dropout.id, workflow: workflow, workflow_app: workflow_app }
              let(:status_filter_sdf_invalid) { create :source_document_file, :file_kind_original, :with_date_performed, workflow_run: status_filter_workflow_run_invalid, slot: slot }
              let(:status_filter_sdf_dropout) { create :source_document_file, :file_kind_original, :with_date_performed, workflow_run: status_filter_workflow_run_dropout, slot: slot }
              before do
                status_filter_sdf_invalid
                status_filter_sdf_dropout
              end

              context "when 'Any status'" do
                include_context "report run create csv custom" do
                  let(:template_struct) { template_structure }
                  let(:trial_of_report) { trial }
                  let(:created_by_user) { user.id }
                  let(:roles_permitted_to_run_report) { [role.id] }
                  let(:res_filters) { {person_status: "any"} }
                end
                it "should show source documents fot Subjects that are Enrolled, Dropped-out or Invalid" do
                  is_expected.to be_truthy
                  expect(report_run.reload.download_link.current_path).to match(/csv/)
                  expect(content.size).to eq 12
                  subject_ids = content.map do |csv_row|
                    csv_row["Person Identifier"]
                  end
                  expect(subject_ids).to include(status_filter_subject_invalid.identifier, status_filter_subject_dropout.identifier)
                end
              end

              context "when 'Exclude invalid'" do
                include_context "report run create csv custom" do
                  let(:template_struct) { template_structure }
                  let(:trial_of_report) { trial }
                  let(:created_by_user) { user.id }
                  let(:roles_permitted_to_run_report) { [role.id] }
                  let(:res_filters) { {person_status: "exclude_invalid"} }
                end
                it "should show only source documents fot Subjects that are Enrolled or Dropped-out" do
                  is_expected.to be_truthy
                  expect(report_run.reload.download_link.current_path).to match(/csv/)
                  expect(content.size).to eq 8
                  subject_ids = content.map do |csv_row|
                    csv_row["Person Identifier"]
                  end
                  expect(subject_ids).to_not include(status_filter_subject_invalid.identifier)
                  expect(subject_ids).to include(status_filter_subject_dropout.identifier)
                end
              end

              context "when 'Only active'" do
                include_context "report run create csv custom" do
                  let(:template_struct) { template_structure }
                  let(:trial_of_report) { trial }
                  let(:created_by_user) { user.id }
                  let(:roles_permitted_to_run_report) { [role.id] }
                  let(:res_filters) { {person_status: "active"} }
                end
                it "should show only source documents fot Subjects that are Enrolled" do
                  is_expected.to be_truthy
                  expect(report_run.reload.download_link.current_path).to match(/csv/)
                  expect(content.size).to eq 4
                  subject_ids = content.map do |csv_row|
                    csv_row["Person Identifier"]
                  end
                  expect(subject_ids).to_not include(status_filter_subject_invalid.identifier, status_filter_subject_dropout.identifier)
                end
              end

            end # subject status filter

            # to be setted during report running
            context "arm filter" do
              let(:arm_trial_1) { create :trial_arm, trial: trial }
              let(:arm_subject_1) { create :subject, trial_site: trial_site_1, trial: trial, trial_arm_id: arm_trial_1.id }
              let(:arm_trial_2) { create :trial_arm, trial: trial }
              let(:arm_subject_2) { create :subject, trial_site: trial_site_1, trial: trial, trial_arm_id: arm_trial_2.id }
              let(:arm_workflow_run_1) { create :workflow_run, :status_completed, slot_visibility: slot_visibility, person_type: "Subject", person_id: arm_subject_1.id, workflow: workflow, workflow_app: workflow_app }
              let(:arm_workflow_run_2) { create :workflow_run, :status_completed, slot_visibility: slot_visibility, person_type: "Subject", person_id: arm_subject_2.id, workflow: workflow, workflow_app: workflow_app }
              let(:arm_sdf_1) { create :source_document_file, :file_kind_original, :with_date_performed, workflow_run: arm_workflow_run_1, slot: slot }
              let(:arm_sdf_2) { create :source_document_file, :file_kind_original, :with_date_performed, workflow_run: arm_workflow_run_2, slot: slot }
              include_context "report run create csv custom" do
                let(:template_struct) { template_structure }
                let(:trial_of_report) { trial }
                let(:created_by_user) { user.id }
                let(:roles_permitted_to_run_report) { [role.id] }
                let(:res_filters) { {trial_arm: arm_trial_1.id.to_s} }
              end
              before do
                arm_sdf_1
                arm_sdf_2
              end
              it "should show only source documents for Subjects in the selected Trial Arm" do
                is_expected.to be_truthy
                expect(report_run.reload.download_link.current_path).to match(/csv/)
                expect(content.size).to eq 4
                expect(content.first["Person Identifier"]).to eq arm_subject_1.identifier
              end
            end

          end # with filter

        end # basic trial data grants also

      end # basic trial data sdf_1 only

    end # not admin user

    context "other trial test" do
      let(:other_template_structure) { { module: module_name, columns: columns } }
      include_context "report run create csv custom" do
        let(:template_struct) { other_template_structure }
        let(:trial_of_report) { other_trial }
        let(:created_by_user) { user.id }
        let(:roles_permitted_to_run_report) { [role.id] }
        let(:res_filters) {}
      end
      before do
        create_grants account, role, workflow
        create_grants account, role, study_1
        create_grants account, role, subject_1
        other_user_role
        other_sdf
      end
      it "testing with other trial data" do
        is_expected.to be_truthy
        expect(report_run.reload.download_link.current_path).to match(/csv/)
        expect(content.size).to eq 4
        csv_item = {}
        subject_ids =
          content.map do |csv_row|
            # csv_item = csv_row if csv_row["Person Identifier"] == other_subject.identifier && csv_row["Source Document Column"] == other_sdf.file_kind.humanize
            csv_item = csv_row if csv_row["Source Document File ID"] == other_sdf.id
            csv_row["Person Identifier"]
          end
        expect(subject_ids).to match_array([other_subject.identifier] * 4)

        expect(csv_item["Trial Name"]).to eq other_trial.name
        expect(csv_item["Trial Abbreviation"]).to eq other_trial.abbreviation
        expect(csv_item["Workflow App Name"]).to eq other_workflow_app.name
        expect(csv_item["Workflow Name"]).to eq other_workflow.name
        expect(csv_item["Workflow Version"]).to eq other_workflow.version_number
        expect(csv_item["Workflow Run ID"]).to eq other_workflow_run.id
        expect(csv_item["Workflow Run Date"]).to eq "#{other_workflow_run.event_date.strftime('%d-%^b-%Y')} UTC"
        expect(csv_item["Workflow Run Status"]).to eq other_workflow_run.status
        expect(csv_item["Workflow Run Outcome"]).to eq other_workflow_run.selected_outcome
        expect(csv_item["Trial Site Name"]).to eq other_workflow_run.person.trial_site.name
        # expect(csv_item["Trial Site Identifier"]).to eq other_workflow_run.person.trial_site.identifier
        expect(csv_item["Trial Site Identifier"]).to eq other_trial_site.identifier
        expect(csv_item["Person Type"]).to eq other_workflow_run.person_type
        expect(csv_item["Person Identifier"]).to eq other_workflow_run.person.identifier
        expect(csv_item["Source Document File ID"]).to eq other_sdf.id
        expect(csv_item["Source Document Category"]).to eq other_sdf.slot.category.name
        expect(csv_item["Source Document Name"]).to eq other_sdf.slot.name
        expect(csv_item["Source Document Column"]).to eq other_sdf.file_kind.humanize
        expect(csv_item["Source Document Type"]).to eq other_sdf.file_type.humanize
        expect(csv_item["Source Document File Status"]).to eq other_sdf.status.humanize
        expect(csv_item["Source Document File Created at"]).to eq "#{other_sdf.created_at.strftime('%d-%^b-%Y %H:%M:%S')} UTC"
        expect(csv_item["Source Document File Updated at"]).to eq "#{other_sdf.updated_at.strftime('%d-%^b-%Y %H:%M:%S')} UTC"
        expect(csv_item["Source Document Slot Turnaround Time"]).to eq TieredUnitFormatter.new.format(other_sdf.turnaround_time)
      end
    end

    context "user running the report lacks original_source_documents_index & show permission" do
      # put only this line to override in all dependacies ???
      # let(:sd_permissions) { {} }
      let(:lacks_wfr_permissions_workflow) { create :workflow, :status_force_approved, preferences: preferences, trial: trial, version_number: 1, workflow_apps: [workflow_app] }
      let(:lacks_wfr_permissions_category) { create :source_document_category, workflow: lacks_wfr_permissions_workflow }
      let(:lacks_wfr_permissions_slot) { create :source_document_slot, category: lacks_wfr_permissions_category, workflow: lacks_wfr_permissions_workflow }
      let(:lacks_wfr_permissions_slot_visibility) { {lacks_wfr_permissions_slot.id.to_s => "visible"} }
      let(:lacks_wfr_permissions_workflow_run) { create :workflow_run, :status_completed, person_type: "Subject", person_id: subject_1.id, slot_visibility: lacks_wfr_permissions_slot_visibility, workflow: lacks_wfr_permissions_workflow, workflow_app: workflow_app }
      let(:lacks_wfr_permissions_sdf) { create :source_document_file, :file_kind_original, :with_date_performed, workflow_run: lacks_wfr_permissions_workflow_run, slot: lacks_wfr_permissions_slot }
      let(:lacks_wfr_permissions_template_structure) { {module: module_name, columns: columns } }
      include_context "report run create csv custom" do
        let(:template_struct) { lacks_wfr_permissions_template_structure }
        # let(:template_struct) { template_structure }
        let(:trial_of_report) { trial }
        let(:created_by_user) { user.id }
        let(:roles_permitted_to_run_report) { [role.id] }
        let(:res_filters) {}
      end
      before do
        create_grants account, role, subject_1
        create_grants account, role, workflow
        create_grants account, role, study_1
        lacks_wfr_permissions_sdf
        user_role
      end
      it "should not see sdf of wf that he can not see" do
        is_expected.to be_truthy
        expect(report_run.reload.download_link.current_path).to match(/csv/)
        expect(content.size).to eq 3
        # Report content
        csv_item = {}
        subject_ids =
          content.map do |csv_row|
            # csv_item = csv_row if csv_row["Person Identifier"] == subject_1.identifier && csv_row["Source Document Column"] == lacks_wfr_permissions_sdf.file_kind.humanize
            csv_item = csv_row if csv_row["Source Document File ID"] == lacks_wfr_permissions_sdf.id
            # csv_item = csv_row if csv_row["Source Document File ID"] == sdf_1.id
            csv_row["Person Identifier"]
          end
        expect(subject_ids).to match_array([subject_1.identifier] * 3)
        expect(csv_item).to be_empty
      end
    end

  end # describe

end # rspec
