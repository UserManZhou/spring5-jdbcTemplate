package com.gec.jdbc.test;

import com.gec.jdbc.config.SpringConfig;
import com.gec.jdbc.entity.Note;
import com.gec.jdbc.service.NoteService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JdbcTemplateTest {

    @Test
    public void testInsert() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Note note = (Note) applicationContext.getBean("Note");
        NoteService noteServiceImpl = (NoteService) applicationContext.getBean("NoteServiceImpl");
        note.setTitle("nihao");
        note.setSummary("ndiawhduiawiud");
        note.setContext("dbuiawdguiawdgaw");
        note.setCreatetime(new Timestamp(System.currentTimeMillis()));
        noteServiceImpl.insertNote(note);

    }

    @Test
    public void testUpdate() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Note note = (Note) applicationContext.getBean("Note");
        NoteService noteServiceImpl = (NoteService) applicationContext.getBean("NoteServiceImpl");
        note.setId(8);
        note.setTitle("nihao2");
//        note.setSummary("ndiawhduiawiud");
//        note.setContext("dbuiawdguiawdgaw");
//        note.setCreatetime(new Timestamp(System.currentTimeMillis()));
        noteServiceImpl.updateNote(note);

    }

    @Test
    public void testDelete() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Note note = (Note) applicationContext.getBean("Note");
        NoteService noteServiceImpl = (NoteService) applicationContext.getBean("NoteServiceImpl");
        note.setId(8);
        noteServiceImpl.deleteNote(note);
    }

    @Test
    public void testQueryCount() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        NoteService noteServiceImpl = (NoteService) applicationContext.getBean("NoteServiceImpl");
        noteServiceImpl.findCountNote();
    }

    @Test
    public void testQueryObject() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        NoteService noteServiceImpl = (NoteService) applicationContext.getBean("NoteServiceImpl");
        Note note = (Note) applicationContext.getBean("Note");
        note.setId(1);
        noteServiceImpl.findNoteObject(note);
    }

    @Test
    public void testQueryList() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        NoteService noteServiceImpl = (NoteService) applicationContext.getBean("NoteServiceImpl");
        noteServiceImpl.findNoteList();
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        System.out.println(timestamp.toLocalDateTime());
    }

    @Test
    public void testBathInsertList() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        NoteService noteServiceImpl = (NoteService) applicationContext.getBean("NoteServiceImpl");
        Note note = (Note) applicationContext.getBean("Note");
        note.setTitle("nihao");
        note.setSummary("ndiawhduiawiud");
        note.setContext("dbuiawdguiawdgaw");
        note.setCreatetime(new Timestamp(System.currentTimeMillis()));
        Object[] objects = {note.getTitle(),note.getSummary(),note.getContext(),note.getCreatetime()};
        Object[] objects2 = {note.getTitle(),note.getSummary(),note.getContext(),note.getCreatetime()};
        List<Object[]> list = new ArrayList<Object[]>(){{
            add(objects);
            add(objects2);
        }};
        noteServiceImpl.batchInsertNote(list);
    }


    @Test
    public void testBathUpdateList() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        NoteService noteServiceImpl = (NoteService) applicationContext.getBean("NoteServiceImpl");
        Note note = (Note) applicationContext.getBean("Note");
        Note note2 = (Note) applicationContext.getBean("Note");
        note.setId(6);
        note.setTitle("nihao2");
        note2.setId(9);
        note2.setTitle("nihao3");

        Object[] objects = {note.getTitle(),note.getId()};
        Object[] objects1 = {note2.getTitle(),note2.getId()};

        List<Object[]> list = new ArrayList<Object[]>();
        list.add(objects);list.add(objects1);

        noteServiceImpl.batchUpdateNote(list);

    }

    @Test
    public void testBathDeleteList() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        NoteService noteServiceImpl = (NoteService) applicationContext.getBean("NoteServiceImpl");
        Note note = (Note) applicationContext.getBean("Note");
        Note note2 = (Note) applicationContext.getBean("Note");
        note.setId(11);
        note2.setId(0);

        Object[] objects = {note.getId()};
        Object[] objects1 = {note2.getId()};

        List<Object[]> list = new ArrayList<Object[]>();
        list.add(objects);list.add(objects1);

        noteServiceImpl.batchDeleteNote(list);

    }
}
