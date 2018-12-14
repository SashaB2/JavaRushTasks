package com.javarush.task.task18.task1815;

import java.util.Collections;
import java.util.List;

/* 
Таблица
*/

public class Solution {

    public class TableInterfaceWrapper implements ATableInterface {

        ATableInterface aTableInterface;
        String newHeaderText;

        public TableInterfaceWrapper(ATableInterface aTableInterface) {
            this.aTableInterface = aTableInterface;
        }

        @Override
        public void setModel(List rows) {
            aTableInterface.setModel(rows);
            System.out.println(rows.size());
        }

        @Override
        public String getHeaderText( ) {
            return aTableInterface.getHeaderText().toUpperCase();

        }

        @Override
        public void setHeaderText(String newHeaderText) {
            aTableInterface.setHeaderText(newHeaderText);
            this.newHeaderText = newHeaderText;
        }
    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}