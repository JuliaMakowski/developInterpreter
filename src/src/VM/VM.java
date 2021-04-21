package VM;

import java.util.Arrays;

public class VM {
    private int [] memory =new int[1000];
    private int dataPointer;
    private int programPointer;

    public VM(){
        Arrays.fill(memory, 0);
        dataPointer=0;
        programPointer=0;
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
                if(dataPointer==0) {//  então desloque o ponteiro de programa para o próximo comando em sequência ao ] correspondente.
                    // Caso contrário, avance o ponteiro de programa.
                } else programPointer++;
                break;
            case ']':
                if (dataPointer!=0) // então retroceda o ponteiro de programa para o [ correspondente.
                break;
            case ',':
                //   lê um caractere do arquivo IF e o armazena na posição apontada pelo ponteiro de dados
                break;
            case '.':
                // escreve no arquivo OF o caractere apontado pelo ponteiro de dados.
                break;
            case '$':
                //  termina o programa e imprime o conteúdo da memória na segunda linha do arquivo OF.
                break;
            default:
                programPointer++;
                break;
        }
    }
}
