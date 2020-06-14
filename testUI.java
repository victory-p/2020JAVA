import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;

public class testUI extends JFrame {
	private JMenu menu;
	private JMenuItem openmenu;
	private JMenuItem savemenu;
	private JMenuBar menuBar;
	private JPanel panel;
	private JPanel hintPanel;
	private JButton hintButton;
	private JButton answerButton;
	private JTextField answerField;
	private JPanel answerPanel;
	private JTextArea testArea;
	private JMenuItem ExitItem;
	private TestListenr listener;
	private JFileChooser fc;

	public testUI(String s) {
		setLayout(null);
		CreatePanel();
		AnswerPanel();
		CreateMenu();
		setTitle(s);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 1000);
		setVisible(true);
	}
	
	public void CreateMenu() {
		menuBar = new JMenuBar();
		menu = new JMenu("메뉴");
		menuBar.add(menu);
		openmenu = new JMenuItem("파일 열기");
		savemenu = new JMenuItem("파일 저장하기");
		openmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fc = new JFileChooser(new File("/Users/parkseungri/Desktop"));
				fc.setDialogTitle("파일 열기");
				int returnVal = fc.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						File file = fc.getSelectedFile();
						BufferedReader input = new BufferedReader(new FileReader(file.getPath()));
						String line = "";
						String s = "";
						while((s = input.readLine()) != null) {
							line += s;
							line += '\n';
					}
					testArea.setText(line);
					if(input != null) {
						input.close();
					}
				}catch(Exception E) {
					E.printStackTrace();
				}
			}
			}});
		savemenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fs = new JFileChooser(new File("/Users/parkseungri/Desktop"));
				fs.setDialogTitle("파일 저장하기");
				int result = fs.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					String content = testArea.getText();
					File fi = fs.getSelectedFile();
					try {
						FileWriter fw = new FileWriter(fi.getPath() + ".txt");
						fw.write(content);
						fw.flush();
						fw.close();
					}catch(Exception E) {
				JOptionPane.showMessageDialog(null, E.getMessage());
				}
			}
		}});
		menu.add(openmenu);
		menu.add(savemenu);
		ExitItem = new JMenuItem("종료(X)");
		menu.add(ExitItem);
		menuBar.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		listener = new TestListenr();
		ExitItem.addActionListener(listener);
		setJMenuBar(menuBar);
	}
	
	public void CreatePanel() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,900,600);
		testArea = new JTextArea();
		testArea.setBounds(40,30,820,560);
		testArea.setEditable(false);
		testArea.setBackground(new Color(70,70,70,255));
		testArea.setLineWrap(true);
		testArea.setForeground(Color.WHITE);
		panel.add(testArea);
		add(panel);
	}
	
	public void AnswerPanel() {
		answerPanel = new JPanel();
		answerPanel.setBackground(Color.BLACK);
		answerPanel.setBounds(0,640,900,40);
		answerField = new JTextField("", 40);
		answerButton = new JButton("정답 입력");
		Answer a = new Answer();
		String answerCheck = a.getAnswer(1);
		answerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answerCheck.contentEquals(answerField.getText())) {
					JOptionPane.showMessageDialog(null, "정답입니다");
				}
			else {
				JOptionPane.showMessageDialog(null, "오답입니다");
			}
			}
		});
		answerPanel.add(answerField);
		answerPanel.add(answerButton);
		add(answerPanel);
	}
	class Answer{
		private String answer;
		public Answer() {
			answer = "";
		}
		public String getAnswer(int n) {
			Scanner inputStream = null;
			String [] line = new String[30];
			int i = 1;
			try {
				inputStream = new Scanner(new File("/Users/parkseungri/Desktop/Hint.txt"));	
			}catch(FileNotFoundException e) {
				System.out.println("Error opening the file");
				System.exit(0);
			}
		while(inputStream.hasNextLine()) {
			inputStream.hasNextInt();
			line[i] = inputStream.nextLine();
			i++;
		}
		inputStream.close();
		this.answer = line[n];
		return answer;
		}
	}
	
	class TestListenr implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == ExitItem) {
				System.exit(1);
			}
		}
	}
}
