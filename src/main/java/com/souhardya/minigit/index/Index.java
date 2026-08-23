package com.souhardya.minigit.index;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Index {

    private final List<IndexEntry> entries;
    private final Path indexFile;

    public Index(Path indexFile) {
        this.entries = new ArrayList<>();
        this.indexFile = indexFile;
    }

    public void add(IndexEntry entry) {

        for(int i=0;i<entries.size();i++)
        {
            IndexEntry existing=entries.get(i);
            if(entries.get(i).getFilePath().equals(entry.getFilePath()))
            {
                entries.set(i,entry);
                return;
            }
        }
        entries.add(entry);
    }

    public void save() throws IOException {

        List<String> lines=new ArrayList<>();
        for (IndexEntry entry:entries){
            String line=entry.getFilePath() + " | " +entry.getHash();
            lines.add(line);
        }
        Files.write(indexFile,lines);
    }
}

// Flow

//add(newEntry)
//    |
//search existing entries
//    |
//same path
//    |
//    |   ------------
//    |              |
//   yes             no
//    |              |
//  replace        keep searching
//    |              |
//  done          reached end
//                   |
//                add new entry