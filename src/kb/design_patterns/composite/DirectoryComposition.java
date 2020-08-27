package kb.design_patterns.composite;

import java.util.ArrayList;
import java.util.List;

interface Component {
    void ls();

    default boolean isDirectory() {
        return false;
    }
}

class File implements Component {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void ls() {
        System.out.println(DirectoryComposition.sb + "-" + name);
    }
}

class Directory implements Component {
    private List<Component> components = new ArrayList<>();
    private String name;

    public Directory(String name) {
        this.name = name;
    }

    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void ls() {
        System.out.println(DirectoryComposition.sb + name);
        DirectoryComposition.sb.append("  ");
        components.forEach(Component::ls);
        DirectoryComposition.sb.setLength(DirectoryComposition.sb.length() - 2);
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

}

public class DirectoryComposition {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Directory music = new Directory("MUSIC");
        Directory amonTobin = new Directory("AMON TOBIN");
        Directory MJS = new Directory("MONTHLY JOINTS SERIES");
        music.add(new File("Szamar Madar.mp3"));
        music.add(amonTobin);
        amonTobin.add(new File("Easy Muffin.mp3"));
        amonTobin.add(new File("Yasawas.mp3"));
        amonTobin.add(MJS);
        MJS.add(new File("Delpher.mp3"));
        music.add(new File("track2.m3u"));
        music.ls();
    }
}
