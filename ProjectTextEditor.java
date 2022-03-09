package FFF;

	// Java-программа для создания текстового редактора с использованием Java
	import java.awt.*;
	import javax.swing.*;
	import java.io.*;
	import java.awt.event.*;
	import javax.swing.plaf.metal.*;
	import javax.swing.text.*;

	class ProjectTextEditor extends JFrame implements ActionListener {
	    // Текстовый компонент
	    JTextArea t, r;
	    // Рамка
	    JFrame f;
	    
	    // Конструктор
	    ProjectTextEditor()
	    {
	        // Создать рамку
	        f = new JFrame("Macrohard Wort");

	        try {
	            // Настройка внешнего вида
	            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
	            // Установить тему на океан
	            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
	        }

	        catch (Exception e) {
	        }

	        // Текстовый компонент
	        t = new JTextArea();

	        // Создать строку меню
	        JMenuBar mb = new JMenuBar();

	        // Создать меню для меню
	        JMenu m1 = new JMenu("File");

	        // Создание пунктов меню
	        JMenuItem mi1 = new JMenuItem("New");
	        JMenuItem mi2 = new JMenuItem("Open");
	        JMenuItem mi3 = new JMenuItem("Save");
	        JMenuItem mi9 = new JMenuItem("Print");

	  

	        // Добавить слушателя действия
	        mi1.addActionListener(this);
	        mi2.addActionListener(this);
	        mi3.addActionListener(this);
	        mi9.addActionListener(this);

	        m1.add(mi1);
	        m1.add(mi2);
	        m1.add(mi3);
	        m1.add(mi9);

	  
	        // Создать меню для меню
	        JMenu m2 = new JMenu("Edit");

	        // Создание пунктов меню
	        JMenuItem mi4 = new JMenuItem("cut");
	        JMenuItem mi5 = new JMenuItem("copy");
	        JMenuItem mi6 = new JMenuItem("paste");

	        // Добавить слушателя действия
	        mi4.addActionListener(this);
	        mi5.addActionListener(this);
	        mi6.addActionListener(this);

	        m2.add(mi4);
	        m2.add(mi5);
	        m2.add(mi6);
	        

	        // Создание пунктов меню
	        JMenuItem mc = new JMenuItem("close");
	        // Добавить слушателя действия
	        mc.addActionListener(this);

	        mb.add(m1);
	        mb.add(m2);
	        mb.add(mc);

	        f.setJMenuBar(mb);
	        f.add(t);
	        f.setSize(500, 500);
	        f.show();
	    }


	    // Если кнопка нажата
	    public void actionPerformed(ActionEvent e)
	    {
	        String s = e.getActionCommand();

	        if (s.equals("cut")) {
	            t.cut();
	        }

	        else if (s.equals("copy")) {
	            t.copy();
	        }

	        else if (s.equals("paste")) {
	            t.paste();
	        }

	        else if (s.equals("Save")) {
	            // Создать объект класса JFileChooser
	            JFileChooser j = new JFileChooser("f:");

	            // Вызвать функцию ShowSaveDialog, чтобы показать диалог сохранения
	            int r = j.showSaveDialog(null);

	            if (r == JFileChooser.APPROVE_OPTION) {

	                // Установить метку на путь к выбранному каталогу
	                File fi = new File(j.getSelectedFile().getAbsolutePath());

	                try {

	                    // Создать файл писателя
	                    FileWriter wr = new FileWriter(fi, false);

	                    // Создать буферизованный писатель для записи
	                    BufferedWriter w = new BufferedWriter(wr);

	                    // Написать
	                    w.write(t.getText());

	                    w.flush();
	                    w.close();

	                }

	                catch (Exception evt) {
	                    JOptionPane.showMessageDialog(f, evt.getMessage());
	                }

	            }

	            // Если пользователь отменил операцию
	            else
	                JOptionPane.showMessageDialog(f, "the user cancelled the operation");
	        }

	        else if (s.equals("Print")) {
	            try {
	            	
	                // распечатать файл
	                t.print();
	            }

	            catch (Exception evt) {
	                JOptionPane.showMessageDialog(f, evt.getMessage());
	            }
	        }

	        else if (s.equals("Open")) {
	        	
	            // Создать объект класса JFileChooser
	            JFileChooser j = new JFileChooser("f:");

	            // Вызвать функцию showsOpenDialog, чтобы показать диалоговое окно сохранения
	            int r = j.showOpenDialog(null);

	            // Если пользователь выбирает файл
	            if (r == JFileChooser.APPROVE_OPTION) {

	                // Установить метку на путь к выбранному каталогу
	                File fi = new File(j.getSelectedFile().getAbsolutePath());
	  
	                try {

	                    // Строка
	                    String s1 = "", sl = "";

	                    // File reader
	                    FileReader fr = new FileReader(fi);

	                    // Буферный ридер
	                    BufferedReader br = new BufferedReader(fr);

	                    // Инициализируем sl
	                    sl = br.readLine();

	                    // Взять ввод из файла
	                    while ((s1 = br.readLine()) != null) {
	                        sl = sl + "\n" + s1;
	                    }

	                    // Установить текст
	                    t.setText(sl);
	                }

	                catch (Exception evt) {
	                    JOptionPane.showMessageDialog(f, evt.getMessage());
	                }
	            }

	            // Если пользователь отменил операцию
	            else
	                JOptionPane.showMessageDialog(f, "the user cancelled the operation");
	        }

	        else if (s.equals("New")) {
	            t.setText("");
	        }
	        
	    }
	  

	    // Основной класс
	    public static void main(String args[])

	    {
	        ProjectTextEditor e = new ProjectTextEditor();
	    }
	}
