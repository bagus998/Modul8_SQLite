package com.example.modul8_sqlite.helper;

import androidx.recyclerview.widget.DiffUtil;

import com.example.modul8_sqlite.database.Note;

import java.util.List;

public class NoteDiffCallback extends DiffUtil.Callback {
    private final List<Note> mOldNoteList;
    private final List<Note> mNewNoteList;

    public NoteDiffCallback(List<Note> oldNoteList, List<Note> newNoteList) {
        this.mOldNoteList = oldNoteList;
        this.mNewNoteList = newNoteList;
    }

    @Override
    public int getOldListSize() {
        return mOldNoteList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewNoteList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldNoteList.get(oldItemPosition).getId() == mNewNoteList.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        final Note oldEmployee = mOldNoteList.get(oldItemPosition);
        final Note newEmployee = mNewNoteList.get(newItemPosition);
        return oldEmployee.getTitle().equals(newEmployee.getTitle()) &&
                oldEmployee.getDescription().equals(newEmployee.getDescription());
    }
}