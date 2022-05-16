package com.example.coderpro;

import java.io.*;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class HelloController {
    Alphabet alphabet = new Alphabet();
    ArrayList<Character> list = new ArrayList<>();
    ArrayList<Character> list1 = new ArrayList<>();
    Path path;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button brut;

    @FXML
    private Button decode;

    @FXML
    private Button encode;

    @FXML
    private TextField keyArea;

    @FXML
    private Button file;

    @FXML
    public void fileClick(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        path = Path.of(file.getParent());
        int c;
        while ((c = bufferedReader.read()) != -1) {
            list.add((char) c);
        }
    }

    @FXML
    public void encodeClick(ActionEvent event) throws IOException {
        int a = Integer.parseInt(keyArea.getText());
        list1 = Encoder.Encode(alphabet.alphabet, list, a);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(path) + "/result.txt"));
        for (int i = 0; i < list1.size(); i++) {
            bufferedWriter.write(list1.get(i));
        }
        bufferedWriter.close();
    }

    public void decodeClick(ActionEvent event) throws IOException {
        int a = Integer.parseInt(keyArea.getText());
        list1 = Decoder.Decode(alphabet.alphabet, list, a);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(path) + "/result.txt"));
        for (int i = 0; i < list1.size(); i++) {
            bufferedWriter.write(list1.get(i));
        }
        bufferedWriter.close();
    }

    public void brutClick(ActionEvent event) throws IOException {
        list1 = Bruteforce.Bruteforce(alphabet.alphabet, list);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(path) + "/result.txt"));
        for (int i = 0; i < list1.size(); i++) {
            bufferedWriter.write(list1.get(i));
        }
        bufferedWriter.close();
    }
    public static int getKey(Map<Integer, Character> alph, char v) {
        for (Map.Entry<Integer, Character> entry : alph.entrySet())
            if (entry.getValue().equals(v)) {
                return entry.getKey();
            }
        return 0;
    }
}





