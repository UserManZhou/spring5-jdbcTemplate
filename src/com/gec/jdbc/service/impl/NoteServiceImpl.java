package com.gec.jdbc.service.impl;

import com.gec.jdbc.entity.Note;
import com.gec.jdbc.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

@Repository(value = "NoteServiceImpl")
public class NoteServiceImpl implements NoteService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void findNote() {
        String sql = "SELECT * FROM `note`";

    }

    @Override
    public void insertNote(Note note){
        String sql = "INSERT INTO `note`(`title`,`summary`,`context`,`createtime`) VALUES (?,?,?,?)";
        int update = jdbcTemplate.update(sql, note.getTitle(), note.getSummary(), note.getContext(), note.getCreatetime());
        System.out.println(update);
    }

    @Override
    public void deleteNote(Note note) {
        String sql = "DELETE FROM `note` WHERE `id` = ?";
        int update = jdbcTemplate.update(sql, note.getId());
        System.out.println(update);
    }

    @Override
    public void updateNote(Note note) {
        String sql = "UPDATE `note` set `title` = ? WHERE `id` = ?";
        int update = jdbcTemplate.update(sql, note.getTitle(), note.getId());
        System.out.println(update);
    }

    @Override
    public void findCountNote() {
        String sql = "SELECT COUNT(`id`) FROM `note`";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(integer);
    }

    @Override
    public void findNoteObject(Note note) {
        String sql = "SELECT * FROM `note` WHERE `id` = ?";
        Note note1 = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Note>(Note.class),note.getId());
        System.out.println(note1.toString());
    }

    @Override
    public void findNoteList() {
        String sql = "SELECT * FROM `note`";
        List<Note> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Note>(Note.class));
        System.out.println(query.toString());
    }

    @Override
    public void batchInsertNote(List<Object[]> list) {
        String sql = "INSERT INTO `note`(`title`,`summary`,`context`,`createtime`) VALUES (?,?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchUpdateNote(List<Object[]> list) {
        String sql = "UPDATE `note` set `title` = ? WHERE `id` = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchDeleteNote(List<Object[]> list) {
        String sql = "DELETE FROM `note` WHERE `id` = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(ints));
    }
}
