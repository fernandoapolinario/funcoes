package funcoes;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;
import javax.swing.text.NumberFormatter;
import javax.swing.text.PlainDocument;


public class Funcoes {
    public static final int yyyy_MM_dd = 1;
    public static final int dd_MM_yyyy = 2;
    public static final int dd_MM_yyyy_HH_mm_ss = 3;
    
    public static final int clienteFisico = 1;
    public static final int clienteJuridico = 2;
    
    public static final int ENTER = 10; public static final int F1 = 112;  public static final int F2 = 113;  public static final int F3 = 114;
    public static final int F4 = 115;  public static final int F5 = 116;  public static final int F6 = 117;  public static final int F7 = 118;   
    public static final int F8 = 119;  public static final int F9 = 120;  public static final int F10 = 121;  public static final int F11 = 122;    public static final int F12 = 123;
    public static final int BACKSPACE = 32;  public static final int SETA_ESQUERDA = 37;   public static final int SETA_CIMA = 38;   public static final int SETA_DIREITA = 39;   public static final int SETA_BAIXO = 40;
    public static final int ESC = 27;
        
    public static void textfieldLetrasMinusculas(JTextField textfield)
    {
        AbstractDocument document = (AbstractDocument) textfield.getDocument();
        document.setDocumentFilter(new DocumentFilter() 
        {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                super.insertString(fb, offset, string.toLowerCase(), attr);
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                super.insertString(fb, offset, text.toLowerCase(), attrs);
            }
        });
    }
    
    public static void gerarMaximizado(JFrame frame)
    {
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);  //Gerar Maximizado
    }
    
    public static void textField_OnlyNumber(JTextField field)
    {
        PlainDocument doc = (PlainDocument) field.getDocument();
        doc.setDocumentFilter(new MyIntFilter());
    }
    
    public static void escToClose(final JDialog dialog)
    {
        //possibilita que o ESC feche o JDialog
        InputMap im = dialog.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap am = dialog.getRootPane().getActionMap();

        im.put(KeyStroke.getKeyStroke(Funcoes.ESC,0), "doSomething");
        am.put("doSomething", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            };
        });
    }
    
    
    public static void enterButton(JPanel panel)
    {
        Component[] componentes = panel.getComponents();
        
        for (Component component : componentes) 
        {
            if (component instanceof JButton) 
            {
                final JButton button = (JButton)component;
                button.getInputMap().put(KeyStroke.getKeyStroke(Funcoes.ENTER,0),"something");
                button.getActionMap().put("something",new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button.doClick();
                    };
                });
            }
            else if (component instanceof JPanel) 
            {
                JPanel panelComp = (JPanel) component;
                Funcoes.enterButton(panelComp);
            }
        }
    }
    public static void enterButton(JSplitPane splitPane)
    {
        Component[] componentes = splitPane.getComponents();
        
        for (Component component : componentes) 
        {
            if (component instanceof JButton) 
            {
                final JButton button = (JButton)component;
                button.getInputMap().put(KeyStroke.getKeyStroke(Funcoes.ENTER,0),"something");
                button.getActionMap().put("something",new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button.doClick();
                    };
                });
            }
            else if (component instanceof JPanel) 
            {
                JPanel panelComp = (JPanel) component;
                Funcoes.enterButton(panelComp);
            }
            else if (component instanceof JSplitPane) 
            {
                JSplitPane split = (JSplitPane) component;
                Funcoes.enterButton(split);
            }
        }
    }
    public static void enterButton(JFrame frame)
    {
        Component[] componentes=frame.getContentPane().getComponents();
        
        for (Component component : componentes) 
        {
            if (component instanceof JButton) 
            {
                final JButton button = (JButton)component;
                button.getInputMap().put(KeyStroke.getKeyStroke(Funcoes.ENTER,0),"something");
                button.getActionMap().put("something",new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button.doClick();
                    };
                });
            }
            else if (component instanceof JPanel) 
            {
                JPanel panel = (JPanel) component;
                Funcoes.enterButton(panel);
            }
            else if (component instanceof JSplitPane) 
            {
                JSplitPane split = (JSplitPane) component;
                Funcoes.enterButton(split);
            }
        }
    }
    public static void enterButton(JDialog dialog)
    {
        Component[] componentes=dialog.getContentPane().getComponents();
        
        for (Component component : componentes) 
        {
            if (component instanceof JButton) 
            {
                final JButton button = (JButton)component;
                button.getInputMap().put(KeyStroke.getKeyStroke(Funcoes.ENTER,0),"something");
                button.getActionMap().put("something",new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button.doClick();
                    };
                });
            }
            else if (component instanceof JPanel) 
            {
                JPanel panel = (JPanel) component;
                Funcoes.enterButton(panel);
            }
            else if (component instanceof JSplitPane) 
            {
                JSplitPane split = (JSplitPane) component;
                Funcoes.enterButton(split);
            }
        }
    }
    
    public static void setarLimiteJTextField(JTextField field, int limit)
    {
        field.setDocument(new LimitarJTextField(limit));
    }
    
    public static void changeColumnSize_JTable(final JTable jtable, final Font font, final int column)
    {
        DefaultTableCellRenderer render = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
                        row, column);
                setFont(font);
                return this;
            }
        };
        jtable.getColumnModel().getColumn(column).setCellRenderer(render);
    }
    
    public static void addKeyListenerJPanel(JPanel panel, KeyListener listener)
    {
        Component[] componentes = panel.getComponents();
        
        for (Component component : componentes) 
        {
            if (component instanceof JTextField) 
            {
                JTextField field = (JTextField) component;
                field.addKeyListener(listener);
            }
        }
    }
    
    
    public static void addMnemonicKeys(JPanel panel)
    {
        /*
        Essa função adiciona uma atalho de teclado para todos os botões do JPanel que vier por parametro
        que pode ser acessado usando a tecla ALT + a letra selecionada
        */
        ArrayList<Character> letrasEscolhidas = new ArrayList();
        Component[] componentes = panel.getComponents();
        
        for (Component component : componentes) 
        {
            if (component instanceof JButton) 
            {
                JButton button = (JButton) component;
                String textButton = button.getText();
//                System.out.println(textButton);
                int tamanho = textButton.length();
//                System.out.println(tamanho);
                int count=0;
                while(count < tamanho)
                {
                    char letra = textButton.charAt(count);
//                    System.out.println(letra);
                    
                    if(letrasEscolhidas.size() > 0)
                    {
                        if(Funcoes.verificaArray(letrasEscolhidas, Character.toUpperCase(letra)))
                        {
                            letrasEscolhidas.add(Character.toUpperCase(letra));
                            button.setMnemonic(letra);
                            count = tamanho;
                            break;
                        }
                    }
                    else
                    {
                        letrasEscolhidas.add(Character.toUpperCase(letra));
                        button.setMnemonic(letra);
                        break;
                    }
                    count++;
                }
            }
        }
//        for(Character s : letrasEscolhidas)
//        {
//            System.out.println(s);
//        }
    }
    public static void addMnemonicKeys(JPanel[] panels)
    {
        /*
        Essa função adiciona uma atalho de teclado para todos os botões do JPanel que vier por parametro
        que pode ser acessado usando a tecla ALT + a letra selecionada
        */
        ArrayList<Character> letrasEscolhidas = new ArrayList();
        for(JPanel painel : panels)
        {
            Component[] componentes = painel.getComponents();

            for (Component component : componentes) 
            {
                if (component instanceof JButton) 
                {
                    JButton button = (JButton) component;
                    String textButton = button.getText();
    //                System.out.println(textButton);
                    int tamanho = textButton.length();
    //                System.out.println(tamanho);
                    int count=0;
                    while(count < tamanho)
                    {
                        char letra = textButton.charAt(count);
    //                    System.out.println(letra);

                        if(letrasEscolhidas.size() > 0)
                        {
                            if(Funcoes.verificaArray(letrasEscolhidas, Character.toUpperCase(letra)))
                            {
                                letrasEscolhidas.add(Character.toUpperCase(letra));
                                button.setMnemonic(letra);
                                count = tamanho;
                                break;
                            }
                        }
                        else
                        {
                            letrasEscolhidas.add(Character.toUpperCase(letra));
                            button.setMnemonic(letra);
                            break;
                        }
                        count++;
                    }
                }
            }
        }
            
//        for(Character s : letrasEscolhidas)
//        {
//            System.out.println(s);
//        }
    }
    
    private static boolean verificaArray(ArrayList<Character> array, char letra)
    {
        int count=0;
        for(int i=0; i<array.size(); i++)
        {
            char letraArray = array.get(i);
            if(letra == letraArray)
            {
                count++;
            }
        }
        
        if(count > 0) return false;
        else return true;
    }
    
    public static void KeyToDoThings_Dispacther(int keyCode, Action actions)
    {
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new Funcoes.Dispatcher(keyCode,actions));
    }
    public static void KeyToDoThings_Dispatcher(int keyCode, JButton button)
    {
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new Funcoes.Dispatcher(keyCode,button));
    }
    public static class Dispatcher implements KeyEventDispatcher {

        private Action acao;
        private int key;
        private JButton button;
        public Dispatcher(int keyCode, Action acao) 
        {
            this.acao = acao;
            this.key = keyCode;
        }
        public Dispatcher(int keyCode, JButton button) 
        {
            this.button = button;
            this.key = keyCode;
        }
        
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED){} 
            else if (e.getID() == KeyEvent.KEY_RELEASED) 
            {
                if(acao != null)
                    acao.actionPerformed(null);
                else if(button != null)
                    button.doClick();
            } 
            else if (e.getID() == KeyEvent.KEY_TYPED){}
            return false;
        }
    }

    public static void KeyButtonAction_KeyBinding(JFrame frame, final int keyCode, final Action action)
    {
        InputMap im = frame.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap am = frame.getRootPane().getActionMap();

        im.put(KeyStroke.getKeyStroke(keyCode,0), "doSomething");
        am.put("doSomething", action);
    }
    public static void KeyButtonAction_KeyBinding(JPanel panel, final int keyCode, final Action action)
    {
        InputMap im = panel.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap am = panel.getRootPane().getActionMap();

        im.put(KeyStroke.getKeyStroke(keyCode,0), "doSomething");
        am.put("doSomething", action);
    }
    public static void KeyButtonAction_KeyBinding(JFrame frame, final int keyCode, final JButton button)
    {
        InputMap im = frame.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap am = frame.getRootPane().getActionMap();

        im.put(KeyStroke.getKeyStroke(keyCode,0), "doSomething");
        am.put("doSomething", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.doClick();
            };
        });
    }
    public static void KeyButtonAction_KeyBinding(JPanel panel, final int keyCode, final JButton button)
    {
        InputMap im = panel.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap am = panel.getRootPane().getActionMap();

        im.put(KeyStroke.getKeyStroke(keyCode,0), "doSomething");
        am.put("doSomething", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.doClick();
            };
        });
    }
    
    public static void KeyButtonAction_KeyBinding(Component comp, final int keyCode, Action action)
    {
        if (comp instanceof JTextField) 
        {  
            final JTextField field = (JTextField) comp;
            field.getInputMap().put(KeyStroke.getKeyStroke(keyCode,0),"something");
            field.getActionMap().put("something",action);
        }
        else if (comp instanceof JFormattedTextField) 
        {
            final JFormattedTextField field = (JFormattedTextField) comp;
            field.getInputMap().put(KeyStroke.getKeyStroke(keyCode,0),"something");
            field.getActionMap().put("something",action);
        }
        else if (comp instanceof JComboBox) 
        {
            final JComboBox field = (JComboBox) comp;
            field.getInputMap().put(KeyStroke.getKeyStroke(keyCode,0),"something");
            field.getActionMap().put("something",action);
        }
        else if (comp instanceof JTable) 
        {
            final JTable field = (JTable) comp;
            field.getInputMap().put(KeyStroke.getKeyStroke(keyCode,0),"something");
            field.getActionMap().put("something",action);
        }
    }
    
    
    public static void KeyButtonAction_KeyListener(JPanel panel, final int keyCode, final JButton button)
    {
        KeyListener listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) 
            {
                if(e.getKeyCode() == keyCode)
                {
                    button.doClick();
                }
            }
        };
        
        Component components[] = panel.getComponents();
        for (Component component : components) 
        {
            if (component instanceof JTextField) 
            {  
                final JTextField field = (JTextField) component;
                field.addKeyListener(listener);
            }
            else if (component instanceof JFormattedTextField) 
            {
                final JFormattedTextField field = (JFormattedTextField) component;
                field.addKeyListener(listener);
            }
            else if (component instanceof JComboBox) 
            {
                final JComboBox field = (JComboBox) component;
                field.addKeyListener(listener);
            }
            else if(component instanceof JPanel)
            {
                KeyButtonAction_KeyListener((JPanel) component, keyCode, button); 
            }
        }
    }
    public static void KeyButtonAction_KeyListener(Component component, final int keyCode, final JButton button)
    {
        KeyListener listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) 
            {
                if(e.getKeyCode() == keyCode)
                {
                    button.doClick();
                }
            }
        };
        
        if (component instanceof JTextField) 
        {  
            final JTextField field = (JTextField) component;
            field.addKeyListener(listener);
        }
        else if (component instanceof JFormattedTextField) 
        {
            final JFormattedTextField field = (JFormattedTextField) component;
            field.addKeyListener(listener);
        }
        else if (component instanceof JComboBox) 
        {
            final JComboBox field = (JComboBox) component;
            field.addKeyListener(listener);
        }
        else if(component instanceof JPanel)
        {
            KeyButtonAction_KeyListener((JPanel) component, keyCode, button); 
        }
        
    }
    
    public static void KeyButtonAction_KeyListener(JFrame frame, final int keyCode, final JButton button)
    {
        KeyListener listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) 
            {
                if(e.getKeyCode() == keyCode)
                {
                    button.doClick();
                }
            }
        };
        Component[] components=frame.getContentPane().getComponents();
        for (Component component : components) 
        {
            if (component instanceof JTextField) 
            {  
                final JTextField field = (JTextField) component;
                field.addKeyListener(listener);
            }
            else if (component instanceof JFormattedTextField) 
            {
                final JFormattedTextField field = (JFormattedTextField) component;
                field.addKeyListener(listener);
            }
            else if (component instanceof JComboBox) 
            {
                final JComboBox field = (JComboBox) component;
                field.addKeyListener(listener);
            }
            else if(component instanceof JPanel)
            {
                KeyButtonAction_KeyListener((JPanel) component, keyCode, button); 
            }
        }
        
    }
    
    public static void setSelectedWhenFocus(JPanel panel)
    {
        Component components[] = panel.getComponents();
        for (Component component : components) 
        {
            if (component instanceof JTextField) 
            {  
                final JTextField field = (JTextField) component;
                field.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        field.selectAll();
                    }
                    @Override
                    public void focusLost(FocusEvent e) {}
                });
            }
            else if (component instanceof JFormattedTextField) 
            {
                final JFormattedTextField field = (JFormattedTextField) component;
                field.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        field.selectAll();
                    }
                    @Override
                    public void focusLost(FocusEvent e) {}
                });
            }
            else if(component instanceof JPanel)
            {
                setSelectedWhenFocus((JPanel) component); 
            }
        }
    }
    
    public static void setSelectedWhenFocus(JFrame frame)
    {
        Component[] components=frame.getContentPane().getComponents();
        for (Component component : components) 
        {  
            if (component instanceof JTextField) 
            {  
                final JTextField field = (JTextField) component;
                field.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        field.selectAll();
                    }
                    @Override
                    public void focusLost(FocusEvent e) {}
                });
            }
            else if (component instanceof JFormattedTextField) 
            {  
                final JFormattedTextField field = (JFormattedTextField) component;
                field.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        field.selectAll();
                    }
                    @Override
                    public void focusLost(FocusEvent e) {}
                });
            }
            else if(component instanceof JPanel)
            {
                setSelectedWhenFocus((JPanel) component); 
            }
        }
    }
    public static void setSelectedWhenFocus(JDialog dialog)
    {
        Component[] components=dialog.getContentPane().getComponents();
        for (Component component : components) 
        {  
            if (component instanceof JTextField) 
            {  
                final JTextField field = (JTextField) component;
                field.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        field.selectAll();
                    }
                    @Override
                    public void focusLost(FocusEvent e) {}
                });
            }
            else if (component instanceof JFormattedTextField) 
            {  
                final JFormattedTextField field = (JFormattedTextField) component;
                field.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        field.selectAll();
                    }
                    @Override
                    public void focusLost(FocusEvent e) {}
                });
            }
            else if(component instanceof JPanel)
            {
                setSelectedWhenFocus((JPanel) component); 
            }
        }
    }
    
    
    public static int roundUp_Int(double valor)
    {
        return (int) Math.ceil(valor);
    }
    
    public static void jFormattedTextField_Formatter(JFormattedTextField textfield)
    {
        DecimalFormat df = new DecimalFormat(); // And here..
        NumberFormatter dnff = new NumberFormatter(df);
        DefaultFormatterFactory factory = new DefaultFormatterFactory(dnff); 
        textfield.setFormatterFactory(factory);
    }
    
    public static String converterDoubleString(double precoDouble) {  
        /*Transformando um double em 2 casas decimais*/  
        DecimalFormat fmt = new DecimalFormat("0.00");   //limita o número de casas decimais      
        String string = fmt.format(precoDouble);  
        String[] part = string.split("[,]");  
        String preco = part[0]+"."+part[1];  
        return preco;  
    }

    public static double converterDoubleDecimal(double precoDouble, int casas) {  
        DecimalFormat fmt = new DecimalFormat("0.00");   
        if(casas == 3) fmt = new DecimalFormat("0.000");  
        if(casas == 4) fmt = new DecimalFormat("0.0000");  
        if(casas == 5) fmt = new DecimalFormat("0.00000");  
        
        String string = fmt.format(precoDouble);  
        String[] part = string.split("[,]");  
        String string2 = part[0]+"."+part[1];  
            double preco = Double.parseDouble(string2);  
        return preco;  
    }
    
    public static String doubleString(double valor, int casas)
    {
        DecimalFormat fmt;
        if(casas == 1) fmt = new DecimalFormat("0.0");  
        else if(casas == 2) fmt = new DecimalFormat("0.00");  
        else if(casas == 3) fmt = new DecimalFormat("0.000");  
        else if(casas == 4) fmt = new DecimalFormat("0.0000");  
        else if(casas == 5) fmt = new DecimalFormat("0.00000");  
        else fmt = new DecimalFormat("0.00");
        return fmt.format(valor);
    }
//    public static Double StringDouble(String valor)
//    { 
//        String[] part = valor.split("[,]");  
//        String string2 = part[0]+"."+part[1];
//        return Double.parseDouble(string2);
//    }
    public static Double StringDouble(String valor)
    { 
        valor = valor.replace(",", ".");
        return Double.parseDouble(valor);
    }
    
    public static String formatoMonetario(BigDecimal valor)
    {
        return NumberFormat.getCurrencyInstance().format(valor);
    }
    public static String formatoMonetario(Double valor)
    {
        return NumberFormat.getCurrencyInstance().format(valor);
    }
    public static String formatoMonetario(Float valor)
    {
        return NumberFormat.getCurrencyInstance().format(valor);
    }
    
    public static BigDecimal monetarioToBigDecimal(String valor)
    {
        valor = valor.replace("R$", "");
        valor = valor.replace(" ", "");
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        ParsePosition parsePosition = new ParsePosition(0);
        Number number = numberFormat.parse(valor, parsePosition);
        return new BigDecimal(number.toString());
    }
    public static double monetarioToDouble(String valor)
    {
        valor = valor.replace("R$", "");
        valor = valor.replace(" ", "");
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        ParsePosition parsePosition = new ParsePosition(0);
        Number number = numberFormat.parse(valor, parsePosition);
        return number.doubleValue();
    }
    
    public static Date StringToDate(String data, int FormatoEntrada) throws Exception 
    {
        if (data == null || data.equals(""))  
            return null;  
          
        Date date = null;  
        try 
        {  
            DateFormat formatter = null;
            if(FormatoEntrada == 1 )
            {
                formatter = new SimpleDateFormat("yyyy/MM/dd");  
            }
            else if(FormatoEntrada == 2 )
            {
                formatter = new SimpleDateFormat("dd/MM/yyyy");  
            }
            else
            {
                return null;
            }
            
            date = (java.util.Date)formatter.parse(data);  
        } 
        catch (ParseException e) 
        {              
            throw e;  
        }  
        return date;  
    }
    public String dateToString(Date data)
    {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");  
        String dataTxt = formato.format(data); 
        return dataTxt;
    }
    public static String dateToString(Date data, int Formato)
    {
        SimpleDateFormat smf = null;
        if(Formato == 1)
        {
            smf = new SimpleDateFormat("yyyy/MM/dd");  
        }
        else if (Formato == 2)
        {
            smf = new SimpleDateFormat("dd/MM/yyyy");  
        }
        
        else if (Formato == 3)
        {
            smf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        }
        String dataTxt = smf.format(data); 
        return dataTxt;
    }
    
    public static void Limpar(Container container) 
    {
        Component components[] = container.getComponents();  
        for (Component component : components) 
        {  
            if (component instanceof JFormattedTextField) 
            {  
                JFormattedTextField field = (JFormattedTextField) component;  
                field.setValue(null);  
            } 
            else if (component instanceof JTextField) 
            {  
                JTextField field = (JTextField) component;  
                field.setText("");  
            } 
            else if (component instanceof JComboBox) 
            {  
                JComboBox combo = (JComboBox) component;  
                combo.setSelectedIndex(0);
            } 
            else if (component instanceof Container) 
            {  
                Limpar((Container) component);  
            } 
        } 
    }
    
    public static void LimparJtable(JTable tabela)
    {
        DefaultTableModel tableModel =(DefaultTableModel) tabela.getModel();  
        tableModel.setNumRows(0);  
    }
    
    public void ajustaColunas(JTable tabela) 
    {  
        tabela.setAutoResizeMode(0);  
        FontMetrics fm = tabela.getGraphics().getFontMetrics();  
        int valorwidthtabela = 0;
        for(int i = 0; i < tabela.getColumnCount(); i++) {  
            String columnName = tabela.getColumnName(i);  
            TableColumn col = tabela.getColumnModel().getColumn(i); 
            int width = fm.stringWidth(columnName)+10;
            col.setMinWidth(width);  
            //valorwidthtabela += width;
            //col.setMinWidth(fm.stringWidth(columnName) + 10);  
        }
        //tabela.setSize(valorwidthtabela, 500);
    }
    public static void Limpar(JPanel painel) 
    {
        Component components[] = painel.getComponents();  
        for (Component component : components) 
        {  
            if (component instanceof JFormattedTextField) 
            {  
                JFormattedTextField field = (JFormattedTextField) component;  
                field.setValue(null);  
            } 
            else if (component instanceof JTextField) 
            {  
                JTextField field = (JTextField) component;  
                field.setText("");  
            }   
            else if (component instanceof JTextArea) 
            {  
                JTextArea field = (JTextArea) component;  
                field.setText("");  
            }  
            else if (component instanceof JCheckBox) 
            {  
                JCheckBox check = (JCheckBox) component;  
                check.setSelected(false);
            }  
            else if (component instanceof JComboBox) 
            {  
                JComboBox combo = (JComboBox) component;  
                combo.setSelectedIndex(0);
            } 
            else if (component instanceof Container) 
            {  
                Limpar((Container) component);  
            }  
        } 
    }

    public void setTrueFalse(Component[] component, boolean bolean)
    {
        for (int i=0; i<component.length; i++)
        {
            component[i].setEnabled(bolean);
        }
    }
    public void setComponent_Visible(Component[] component, boolean bolean)
    {
        for (Component component1 : component) 
        {
            component1.setVisible(bolean);
        }
    }

    public static void setTrueFalse(JPanel panel, boolean x)
    {
        Component components[] = panel.getComponents();  
        for (Component component : components) 
        {  
            
            if (component instanceof JLabel) 
            {  
            }
            else
            {
                component.setEnabled(x);
            }
        } 
    }
    public void SetarComboParaZero(JComboBox[] combo)
    {
        for(int i=0; i<combo.length; i++)
        {
            combo[i].setSelectedIndex(0);
        }
    }
    
    public boolean VerificaCamposNulos(Component[] itens)
    {
        boolean x = false;
        try
        {
            int contFor = 0;
            int contIf = 0;
            for (Component component : itens) 
            {
                contFor++;
                if (component instanceof JFormattedTextField) 
                {
                    JFormattedTextField textfield = (JFormattedTextField)component;  
                    textfield.requestFocus();
                    if(textfield.getValue() != null)
                    {
                        contIf++;
                    }
                    //System.out.println("FormattedTextField: '"+textfield.getValue()+"'");
                }
                else if (component instanceof JTextField) 
                {  
                    JTextField textfield = (JTextField)component;  
                    if(textfield.getText().length() > 0)
                    {
                        contIf++;
                    }
                    //System.out.println("TextField: '"+textfield.getText()+"'");
                }
                else if (component instanceof JComboBox) 
                {  
                    JComboBox combo = (JComboBox)component;  
                    if(combo.getSelectedIndex() >= 0 && !combo.getSelectedItem().equals(""))
                    {
                        contIf++;
                    }
                    else if(combo.getSelectedIndex() > 0)
                    {
                        contIf++;
                    }
                    //System.out.println("ComboIndex: "+combo.getSelectedIndex());
                }
                else if (component instanceof JDateChooser) 
                {  
                    JDateChooser data = (JDateChooser)component;  
                    if(data.getDate() != null)
                    {
                        contIf++;
                    }
                }
                
            }
            if(contIf == contFor)
            {
                x = true;
            }
            else
            {
                x = false;
            }
        }
        catch(NullPointerException n)
        {
            JOptionPane.showMessageDialog(null, n);
        }
        
        return x;
    }
    
    public static boolean isCNPJ(String CNPJ) {
        CNPJ = CNPJ.trim();
        CNPJ = CNPJ.replace(".", "");
        CNPJ = CNPJ.replace("/", "");
        CNPJ = CNPJ.replace("-", "");
        // considera-se erro CNPJ's formados por uma sequencia de numeros iguais
        if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") ||
        CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
        CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||
        CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
        CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") ||
        (CNPJ.length() != 14)){
        return(false);
    }

        char dig13, dig14;
        int sm, i, r, num, peso;

        try 
        {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i=11; i>=0; i--) 
            {
                // converte o i-ésimo caractere do CNPJ em um número:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posição de '0' na tabela ASCII)
                num = (int)(CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig13 = '0';
            else dig13 = (char)((11-r) + 48);

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i=12; i>=0; i--) 
            {
                num = (int)(CNPJ.charAt(i)- 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig14 = '0';
            else dig14 = (char)((11-r) + 48);

            // Verifica se os dígitos calculados conferem com os dígitos informados.
            if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
                return(true);
            else return(false);
        } 
        catch (InputMismatchException erro) 
        {
            return(false);
        }
    }

    public static String imprimeCNPJ(String CNPJ) {
        // máscara do CNPJ: 99.999.999.9999-99
        return(CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "." +
        CNPJ.substring(5, 8) + "." + CNPJ.substring(8, 12) + "-" +
        CNPJ.substring(12, 14));
    }
    
    public static boolean isCPF(String CPF) 
    {
        CPF = CPF.trim();
        CPF = CPF.replace(".", "");
        CPF = CPF.replace("-", "");
        
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
        CPF.equals("22222222222") || CPF.equals("33333333333") ||
        CPF.equals("44444444444") || CPF.equals("55555555555") ||
        CPF.equals("66666666666") || CPF.equals("77777777777") ||
        CPF.equals("88888888888") || CPF.equals("99999999999") ||
        (CPF.length() != 11)){
            return(false);
        }
            
        char dig10, dig11;
        int sm, i, r, num, peso;

        try 
        {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) 
            {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int)(CPF.charAt(i) - 48);  
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
               dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) 
            {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
               dig11 = '0';
            else dig11 = (char)(r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return(true);
            else return(false);
        }
        catch (InputMismatchException erro) {
            return(false);
        }
    }

    public static String imprimeCPF(String CPF) {
        return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
        CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
    }
       
}
