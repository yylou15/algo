package dailyKill.printTrace;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<String, Folder> rootFolders = new HashMap<>();
        while (n-- > 0){
            String[] folderNames = scanner.next().split("\\\\");
            if (!rootFolders.keySet().contains(folderNames[0])){
                rootFolders.put(folderNames[0],new Folder());
            }
            Folder ptr = rootFolders.get(folderNames[0]);
            for (int i = 1; i < folderNames.length; i++) {
                if (!ptr.children.keySet().contains(folderNames[i]))
                    ptr.children.put(folderNames[i],new Folder());

                ptr = ptr.children.get(folderNames[i]);
            }

        }
        int end = scanner.nextInt();
        dfs(rootFolders,"");
        System.out.println();
    }

    private static void dfs(Map<String, Folder> folders, String index) {
        Iterator<String> iterator = folders.keySet().iterator();
        while (iterator.hasNext()){
            String folderName = iterator.next();
            System.out.println(index + folderName);
            Folder folder = folders.get(folderName);
            dfs(folder.children,index + "  ");
        }
    }
}

class Folder {
    Map<String, Folder> children = new HashMap<>();
}
