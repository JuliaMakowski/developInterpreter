package VM;

import Archive.FileManager;

import java.util.Arrays;

public class VM {
    private int [] memory =new int[1000];
    private int dataPointer;
    private int programPointer;
    private FileManager fileManager;
    private static String archive;
    private int inputIndex;

    public VM(){
        Arrays.fill(memory, 0);
        this.dataPointer=0;
        this.programPointer=0;
        this.fileManager = new FileManager();
        this.inputIndex=0;
    }

    public void run(){
        archive = FileManager.read("SOURCE.txt");
        if (validation(archive)){
            System.out.println("Archive validated!");
            System.out.println(FileManager.read("SOURCE.txt"));
            fileManager.flush("OF.txt");

            while(programPointer < archive.length()){
                char rule = archive.charAt(programPointer);
                commands(rule);
            }
        } else System.exit(0);
    }

    private boolean validation(String archive){
        int open = 0, close = 0;
        for (char c: archive.toCharArray()){
            if(c == '[') open++;
            if(c == ']') close++;
        }

        if(open != close){
            System.err.println("Error: brackets missing");
            return false;
        }
        return true;
    }

    public void commands(char c){
        switch (c){
            case '>':
                dataPointer++;
                programPointer++;
                break;
            case '<':
                dataPointer--;
                programPointer++;
                break;
            case '+':
                memory[dataPointer]++;
                programPointer++;
                break;
            case '-':
                memory[dataPointer]--;
                programPointer++;
                break;
            case '[':
                if(memory[dataPointer]==0) {
                    for(; archive.charAt(programPointer) != ']'; programPointer++);
                    programPointer++;
                } else programPointer++;
                break;
            case ']':
                if (memory[dataPointer]!=0){
                    for(; archive.charAt(programPointer) != '['; programPointer--);
                    // então retroceda o ponteiro de programa para o [ correspondente.
                }else programPointer++;
                break;
            case ',':
                memory[dataPointer]=FileManager.read("IF.txt").charAt(inputIndex);
                inputIndex++;
                programPointer++;
                //   lê um caractere do arquivo IF e o armazena na posição apontada pelo ponteiro de dados
                break;
            case '.':
                String caractere = String.valueOf(memory[dataPointer]);
                FileManager.write("OF.txt", caractere);
                programPointer++;
                // escreve no arquivo OF o caractere apontado pelo ponteiro de dados.
                break;
            case '$':
                StringBuilder msg = new StringBuilder("\n");
                for(int i = 0; i < memory.length;i++){
                    msg.append("" + memory[i]);
                }
                fileManager.write("OF.txt",msg.toString());
                programPointer++;
                //  termina o programa e imprime o conteúdo da memória na segunda linha do arquivo OF.
                break;
            default:
                programPointer++;
                break;
        }
    }
}
