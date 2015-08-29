package funcoes;



import java.io.File;
import javax.swing.JOptionPane;

public class CriarPasta {
    
    private String caminhoDir = "";
    private String nomePasta = "";
    
    public CriarPasta(String nomePasta, String caminhoDir) 
    {
        this.nomePasta = nomePasta;
        this.caminhoDir = caminhoDir;
    }

    public CriarPasta() {
    }

    public void criarPasta()
    {
        String separador = java.io.File.separator;   
        if(caminhoDir.isEmpty())
            System.out.println("Caminho não configurado!");
        
        else if(nomePasta.isEmpty())
            System.out.println("Nome da pasta não definico");
        
        else
        {
            try 
            {       
                String nomeDiretorio = caminhoDir + separador + nomePasta;   
                if (!new File(nomeDiretorio).exists()) // Verifica se o diretório existe.   
                {
                    (new File(nomeDiretorio)).mkdir();   // Cria o diretório  
                    System.out.println("Pasta criada!");
                }   
                else
                    System.out.println("Pasta já existe!");
            } 
            catch (Exception ex) 
            {   
                JOptionPane.showMessageDialog(null,"Err","Erro ao criar o diretório" + ex.toString(),JOptionPane.ERROR_MESSAGE);   
            }  
        }
    }
    
    public void renomearPasta(String caminhoPasta, String novoNome)
    {
        File file = new File(caminhoPasta);
        if(file.isDirectory())
        {
            file.renameTo(new File(novoNome));
        }
    }
    
}
