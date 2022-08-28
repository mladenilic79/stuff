package a_functional;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J_IO_file {

    public static void main(String[] args) throws IOException {

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< variables >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // prepare data
        String randomString = "perovic";
        byte[] randomByteArray = randomString.getBytes();
        
        // file paths
        String dirPath = "D:\\IT PROGRAMMING\\6 java 0 cheatSheet basics";
        String path1 = "D:\\IT PROGRAMMING\\6 java 0 cheatSheet basics\\random1.txt";
        String path2 = "D:\\IT PROGRAMMING\\6 java 0 cheatSheet basics\\random2.txt";
        
        // Creates a directory object in memory
        File randomDir = new File(dirPath);
        
        /*
        Make a file object and define where to save it in the file system
        (if made without filepath default save location is jvm or class loc.)
         */
        File randomFile = new File(path1);
        File randomFile2 = new File(path2);

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< directories >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // Make an actual directory
        randomDir.mkdir();

        // list file names in dir & store in array
        String[] filesInDir = randomDir.list();
        List<String> dirList = new ArrayList<>();
        for (String fileName : filesInDir) {
            System.out.println(fileName);
            dirList.add(fileName);
        }

        // list file objects in dir & store in array
        File[] filesInDir2 = randomDir.listFiles();
        List<File> fileList = new ArrayList<>();
        for (File fileName : filesInDir2) {
            fileList.add(fileName);
        }

        // You can only delete a directory if it is empty
        if (randomDir.delete()) {
            System.out.println("Directory Deleted");
        }
        
        // create again
        randomDir.mkdir();
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< files >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // createNewFile creates the file in the file system
        randomFile.createNewFile();

        // basics
        System.out.println("Is file exists: " + randomFile.exists());
        System.out.println("Is this a file: " + randomFile.isFile());
        System.out.println("Is this directory: " + randomDir.isDirectory());
        System.out.println("File name is: " + randomFile.getName());

        /*
        path
        Returns the path for the file or directory
        */
        String filePath = randomFile.getCanonicalPath();
        // Output path for file unless path wasn't defined when File was created
        System.out.println("New Name: " + randomFile.toString());
        // if file created without defining path getParent will return null
        System.out.println("Parent directory is: " + randomFile.getParent());

        // attributes
        System.out.println("File is readable: " + randomFile.canRead());
        System.out.println("File is writable: " + randomFile.canWrite());
        System.out.println("Is this hidden: " + randomFile.isHidden());

        // modifying & deleting
        
        // return milliseconds since Jan 1, 1970 when modified
        System.out.println("Last modified: " + randomFile.lastModified());
        // Return size of file in bytes
        System.out.println("Size of file: " + randomFile.length());

        // Changes the name of the file (and back)
        randomFile.renameTo(randomFile2);

        // You call delete to delete a file
        if (randomFile2.delete()) {
            System.out.println("File Deleted");
        }
        
        // create again
        randomFile.createNewFile();
        randomFile2.createNewFile();
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< file output Stream & file input Stream >>>>> @@@@@@@@@@@@@@@@@@
        
        /*
        for primitive data types both bytes & chars
        prefered for bytes
        */
        
        // for overriding
        FileOutputStream fos = new FileOutputStream(randomFile);
        // for appending
        FileOutputStream fos1 = new FileOutputStream("primer1.txt", true);

        // bytes method
        fos.write(104);
        fos.write(101);
        fos.write(108);
        fos.write(108);
        fos.write(111);

        // string method
        fos.write("\npozdrav".getBytes());
        fos.write("3.5".getBytes());
        fos.write("\n".getBytes());

        // bytearray method
        fos.write(randomByteArray);

        // kroz for petlju
        int[] num5 = {101, 102, 103};
        String[] str5 = {"pera", "zoka", "laza"};
        for (int j = 0; j < num5.length - 1; j++) {
            fos.write(num5[j]);
            fos.write(str5[j].getBytes());
            fos.write("\n".getBytes());
        }

        fos.flush();
        fos.close();

        FileInputStream fis = new FileInputStream(randomFile);

        // karakter po karakter
        System.out.println(fis.read());
        System.out.println(fis.read());
        System.out.println(fis.read());

        // poznat broj karaktera sa for petljom
        for (int j=0; j<13; j++) {
            char char5 = (char) fis.read();
            System.out.print(char5);         
        }

        // nepoznat broj karaktera sa while
        while (true) {
            int char5 = fis.read();
            if (char5 == -1) {
                break;
            }
            System.out.println((char) char5);
        }

        // skraceno napisani while
        int char6;
        while ((char6 = fis.read()) != -1) {
            System.out.println((char) char6);
        }

        fis.close();

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< data Input Stream & data Output Stream >>>>> @@@@@@@@@@@@@@@@@@
        
        /*
        use with file input stream & file output stream to read/write data in
        primitive types instead of only raw bytes
        */

        FileOutputStream fos2 = new FileOutputStream(randomFile);
        DataOutputStream dos = new DataOutputStream(fos2);
        // writing string to a file encoded as modified UTF-8
        dos.writeUTF(randomString);

        fos2.flush();
        dos.flush();
        fos2.close();
        dos.close();
        
        // Reading data from the same file
        FileInputStream fis2 = new FileInputStream(randomFile);
        DataInputStream dis = new DataInputStream(fis2);
        while(dis.available()>0) {
            String line = dis.readUTF();
            System.out.println(line);
        }
        
        fis2.close();
        dis.close();

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< buffered streams >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        // add buffer & speed up other streams 
        
        FileOutputStream fos3 = new FileOutputStream(randomFile);
        BufferedOutputStream bos = new BufferedOutputStream(fos3);
        bos.write(randomByteArray);

        fos3.flush();
        bos.flush();
        fos3.close();
        bos.close();
        
        FileInputStream fis3 = new FileInputStream(randomFile);
        BufferedInputStream bis = new BufferedInputStream(fis3);
        int content;
        while ((content = bis.read()) != - 1){
            System.out.print((char) content);
        }
        
        fis3.close();
        bis.close();
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< file writer & file reader >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // prefered method for characters and text files
        
        // writing
        FileWriter fw = new FileWriter(randomFile);
        fw.write("hello world");

        fw.flush();
        fw.close();

        // reading one character at the time
        FileReader fr = new FileReader(randomFile);
        int char7;
        while ((char7 = fr.read()) != -1) {
            System.out.println((char) char7);
        }

        fr.close();

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< buffered writer & reader >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        /*
        for characters and strings
        wrapper for fileWriter & fileReader, gives buffer & speed
        */
        
        FileWriter fw2 = new FileWriter(randomFile);
        BufferedWriter bw = new BufferedWriter(fw2);
        bw.write(randomString);

        fw2.flush();
        bw.flush();
        fw2.close();
        bw.close();
        
        FileReader fr2 = new FileReader(randomFile);
        BufferedReader br = new BufferedReader(fr2);
        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }

        fr2.close();
        br.close();
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< print writer >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // (added options for formated printing in compare to FileWriter)
        
        PrintWriter pw = new PrintWriter(randomFile);
        pw.write(randomString);
        pw.println("pera");

        pw.close();
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< scanner file reader >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        Scanner sc = new Scanner(randomFile);
            
        System.out.println(sc.next());
        // or
        while (sc.hasNext()) {
            System.out.println(sc.next());
        }
        // or
        while (sc.hasNext()) {
            String item = sc.next();
            System.out.println(item);
        }
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // FileReader & FileWriter simultaniously from one to other >>>>> @@@@@@
        
        FileReader fr3 = new FileReader(randomFile);
        FileWriter fw3 = new FileWriter(randomFile2);

        int temp;
        while ((temp = fr3.read()) != -1){
            fw3.write(temp);
        }

        fw3.flush();
        fr3.close();
        fw3.close();
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< byte array output stream >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // Write into multiple files simultaniously
        
        FileOutputStream fos4 = new FileOutputStream(randomFile);
        FileOutputStream fos5 = new FileOutputStream(randomFile2);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(randomByteArray);

        baos.writeTo(fos4);
        baos.writeTo(fos5);

        baos.flush();
        fos4.flush();
        fos5.flush();
        fos4.close();
        fos5.close();
        baos.close();
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< nio path >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // path object
        
        // variables
        String dirPath2 = "D:\\IT PROGRAMMING\\6 java 0 cheatSheet basics\\test2";
        String path4 = "D:\\IT PROGRAMMING\\6 java 0 cheatSheet basics\\test2\\random1.txt";
        String path5 = "D:\\IT PROGRAMMING\\6 java 0 cheatSheet basics\\test2\\random2.txt";
        
        // returning path object
        Path pathA = FileSystems.getDefault().getPath(path4);
        // or shorthand
        Path pathB = Paths.get(path5);
        // dir path
        Path pathDir = Paths.get(dirPath2);
        // since java 11 also
        // Path googlePath = Path.of(URI.create("www.google.com"));
        Path studentFilePath = Path.of("/home/Students/student.txt");
        
        // variables for temp
        String tempDir = "D:\\IT PROGRAMMING\\6 java 0 cheatSheet basics\\";
        String tempFile = "D:\\IT PROGRAMMING\\6 java 0 cheatSheet basics\\test3\\random3.txt";
        
        // temp path
        Path pathTempDir = Paths.get(tempDir);
        Path pathTempFile = Paths.get(tempFile);
        
        // create again
        Files.createDirectory(pathDir);
        Files.createFile(pathA);
        Files.createFile(pathB);
        
        // path elements
        
        // path to string
        System.out.format("toString: %s%n", pathA.toString());
        // Returns the number of elements in the path
        System.out.format("getNameCount: %d%n", pathA.getNameCount());
        // returns file name
        System.out.format("getFileName: %s%n", pathA.getFileName());
        // returns parent
        System.out.format("getParent: %s%n", pathA.getParent());
        // Returns the root of the path
        System.out.format("getRoot: %s%n", pathA.getRoot());
        // Returns the path element corresponding to the specified index
        System.out.format("getName(0): %s%n", pathA.getName(0));
        // Returns the subsequence of the Path
        System.out.format("subpath(0,2): %s%n", pathA.subpath(0,2));
        
        // converting path
        
        // converting the path to a string that can be opened from a browser
        System.out.format("%s%n", pathA.toUri());
        /*
        converting to real path of an existing file (resolves sympolic links,
        remove redunduncies, if relative path returns absolute path
        */
        Path newPath5 = pathA.toRealPath();
        // returns absolute path of a path
        Path newPath6 = pathA.toAbsolutePath();
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< nio attributes >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        boolean fileCheckingOptions1 = Files.exists(pathA);
        boolean fileCheckingOptions2 = Files.notExists(pathA);
        boolean fileCheckingOptions3 = Files.isReadable(pathA);
        boolean fileCheckingOptions4 = Files.isWritable(pathA);
        boolean fileCheckingOptions5 = Files.isExecutable(pathA);

        BasicFileAttributes attribute 
                = Files.readAttributes(pathA, BasicFileAttributes.class);

        System.out.println("creationTime: " + attribute.creationTime());
        System.out.println("lastAccessTime: " + attribute.lastAccessTime());
        System.out.println("lastModifiedTime: " + attribute.lastModifiedTime());

        System.out.println("isDirectory: " + attribute.isDirectory());
        System.out.println("isRegularFile: " + attribute.isRegularFile());
        System.out.println("isSymbolicLink: " + attribute.isSymbolicLink());
        System.out.println("size: " + attribute.size());
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< nio listing directories >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // listing file system root directories
        Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
        for (Path name : dirs) {
            System.err.println(name);
        }

        // listing directories content
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(pathDir)) {
            for (Path file : stream) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException x) {
            /*
            IOException can never be thrown by the iteration.
            In this snippet, it can only be thrown by newDirectoryStream.
            */
            System.err.println(x);
        }
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< nio regex - preskocio >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< nio create & delete files & directories >>>>> @@@@@@@@@@@@@@@@@
        
        // delete
        Files.delete(pathA);
        Files.delete(pathB);
        Files.delete(pathDir);
        
        // create directory
        Files.createDirectory(pathDir);
        // create direcroty & parent directories in the same time
        Files.createDirectories(pathDir);

        // Create the empty file with default permissions, etc.
        Files.createFile(pathA); // optional attributes after path
        Files.createFile(pathB);

        // check if the file paths are the same
        boolean isSameFile = Files.isSameFile(pathA, pathB);
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< nio temporary files & directories >>>>> @@@@@@@@@@@@@@@@@@@@@@@
        
        Path path7 = Files.createTempDirectory(pathTempDir, "test3");
        Path file7 = Files.createTempFile(path7, "privremenFajl", ".tmp");
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< nio move & copy >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        Path pathSource = pathA;
        Path pathTarget = pathB;

        // for directory if coppied, file inside are not coppied
        Files.copy(pathSource, pathTarget, StandardCopyOption.REPLACE_EXISTING);
        Files.move(pathSource, pathTarget, StandardCopyOption.REPLACE_EXISTING);

        /*
        StandardCopyOption options:

        (for copy replace existing, copy attributes and nofollow links)

        REPLACE_EXISTING : If the target file exists, then the target file is
        replaced if it is not a non-empty directory. If the target file
        exists and is a symbolic link, then the symbolic link itself, not the
        target of the link, is replaced.

        COPY_ATTRIBUTES : Attempts to copy the file attributes associated
        with this file to the target file. The exact file attributes that are
        copied is platform and file system dependent and therefore
        unspecified.

        NOFOLLOW_LINKS : Symbolic links are not followed. If the file is a
        symbolic link, then the symbolic link itself, not the target of the
        link, is copied. It is implementation specific if file attributes can
        be copied to the new link. In other words, the COPY_ATTRIBUTES option
        may be ignored when copying a symbolic link.

        (for move replace existing and atomic move)

        ATOMIC_MOVE : The move is performed as an atomic file system
        operation and all other options are ignored. If the target file
        exists then it is implementation specific if the existing file is
        replaced or this method fails by throwing an IOException. If the move
        cannot be performed as an atomic file system operation then
        AtomicMoveNotSupportedException is thrown.
        */
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< nio open options (enums are supported) >>>>> @@@@@@@@@@@@@@@@@@
        
        /*
        WRITE – Opens the file for write access.

        APPEND – Appends the new data to the end of the file. This option is
          used with the WRITE or CREATE options.

        TRUNCATE_EXISTING – Truncates the file to zero bytes. This option is
          used with the WRITE option.

        CREATE_NEW – Creates a new file and throws an exception if the file
         already exists.

        CREATE – Opens the file if it exists or creates a new file if it
         does not.

        DELETE_ON_CLOSE – Deletes the file when the stream is closed. This
         option is useful for temporary files.

        SPARSE – Hints that a newly created file will be sparse. This
         advanced option is honored on some file systems, such as NTFS,
         where large files with data "gaps" can be stored in a more
         efficient manner where those empty gaps do not consume disk space.

        SYNC – Keeps the file (both content and metadata) synchronized with
         the underlying storage device.

        DSYNC – Keeps the file content synchronized with the underlying
         storage device.
        */
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< nio reading & writing unclear >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // one of the ways
        
        Charset latinCharset3 = Charset.forName("ISO-8859-3");
        
        Path path8 = Files.writeString(Files.createTempFile("test", ".txt"), "test file content");
        Path path9 = Files.writeString(Files.createTempFile("test", ".txt"), "test file content", latinCharset3);
        Path path10 = Files.writeString(Path.of("student-mod.txt"),"neki string");
        
        String s8 = Files.readString(path8);
        String s9 = Files.readString(path9, latinCharset3);
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< nio reading & writing small files (small file only) >>>>> @@@@@
        
        // read option 1 (byte array)
        byte[] nioSmall1 = Files.readAllBytes(pathA);
        // read option 2 (string list)
        List<String> nioSmall2 = Files.readAllLines(pathA);
        // write
        Files.write(pathA, randomByteArray, StandardOpenOption.APPEND);
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< nio reading & writing buffered methods for text files >>>>> @@@
        
        // charset here is optional // for both read & write
        Charset charset = Charset.forName("US-ASCII"); 

        try (BufferedReader reader = Files.newBufferedReader(pathA, charset)) {
            String temp2 = null;
            while ((temp2 = reader.readLine()) != null) {
                System.out.println(temp2);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
            x.printStackTrace();
        }

        try (BufferedWriter writer 
                = Files.newBufferedWriter(
                        pathA, charset, StandardOpenOption.APPEND)){
            /*
            String to be written off
            Offset from which to start reading characters len
            Number of characters to be written
            */
            writer.write(randomString, 0, randomString.length());
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< nio reading & writing unbuffered streams >>>>> @@@@@@@@@@@@@@@@
        
        try (InputStream in = Files.newInputStream(pathA);
            BufferedReader reader 
                    = new BufferedReader(new InputStreamReader(in))) {
            String temp2 = null;
            while ((temp2 = reader.readLine()) != null) {
                System.out.println(temp2);
            }
        } catch (IOException x) {
            System.err.println(x);
        }

        try (OutputStream out 
                = new BufferedOutputStream(
                        Files.newOutputStream(pathA, CREATE, APPEND))) {
            out.write(randomByteArray, 0, randomByteArray.length);
        } catch (IOException x) {
            System.err.println(x);
        }
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< OS methods >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // get default file system
        PathMatcher matcher 
                = FileSystems.getDefault().getPathMatcher ("glob:*.*");

        // get path string separator
        String separator1 = File.separator;
        // or
        String separator2 = FileSystems.getDefault().getSeparator();

        // get file system stores (c, d, .. )
        for (FileStore store : FileSystems.getDefault().getFileStores()) {
            System.out.println(store);
        }

        /*
        If you want to retrive the file store where a particular file is
        located, use the getFileStore method in the Files class, as follows:
        */
        FileStore store= Files.getFileStore(pathA);
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // delete again
        Files.delete(pathA);
        Files.delete(pathB);
        Files.delete(pathDir);
    }
}
