package org.daydevjv.coursebook.db;

import org.daydevjv.coursebook.model.Tag;

import java.util.List;
import java.util.Optional;

public class TagDao implements Dao<Tag> {
    @Override
    public Optional<Tag> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Tag> getAll() {
        return null;
    }

    @Override
    public void save(Tag tag) {

    }

    @Override
    public void update(Tag tag) {

    }

    @Override
    public void delete(Tag tag) {

    }
}
