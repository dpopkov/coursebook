package org.daydevjv.coursebook.model;

import java.util.Objects;

public class Tag {
    private int id;
    private String name;

    public Tag(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tag{id=" + id + ", name='" + name + '\'' + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tag tag = (Tag) obj;
        return id == tag.id && name.equals(tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
