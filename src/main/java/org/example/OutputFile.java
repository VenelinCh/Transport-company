package org.example;

import org.example.entity.Payment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class OutputFile<T> {
   private List<T> list;

   public OutputFile(List<T> list) {
      this.list = list;
   }

   public void output( String fileName){
      try{
         Files.deleteIfExists(Paths.get(fileName));
         Files.createFile(Paths.get(fileName));
         for(T t:this.list){
            Files.writeString(Paths.get(fileName),t.toString() + System.lineSeparator(),StandardOpenOption.APPEND);
         }

      }catch(IOException e){
         e.getStackTrace();
      }
   }
}
