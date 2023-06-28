package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import service.ClipBoardCopyService;
import service.ConversionService;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtInputVal;
	private JTextField txtConvertedVal;
	
	
	/**
	 * Create the frame.
	 */
	public MainScreen() {
		
		
		
		setTitle("Phonetic Conversion Tool");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 501, 336);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblInputValue = new JLabel("Input Value :");
		lblInputValue.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblInputValue.setBounds(36, 25, 139, 38);
		panel.add(lblInputValue);
		
		txtInputVal = new JTextField();
		txtInputVal.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(0, 0, 0)));
		txtInputVal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtInputVal.setBounds(105, 68, 329, 32);
		panel.add(txtInputVal);
		txtInputVal.setColumns(10);
		
		JLabel lblConvertedValue = new JLabel("Converted Value :");
		lblConvertedValue.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConvertedValue.setBounds(36, 151, 166, 38);
		panel.add(lblConvertedValue);
		
		txtConvertedVal = new JTextField();
		txtConvertedVal.setEditable(false);
		txtConvertedVal.setFont(new Font("MS PGothic", Font.BOLD, 13));
		txtConvertedVal.setColumns(10);
		txtConvertedVal.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(0, 0, 0)));
		txtConvertedVal.setBounds(105, 194, 329, 32);
		panel.add(txtConvertedVal);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String txtInputValue = txtInputVal.getText();
				
				ConversionService conversionService = new ConversionService();
				
				conversionService.convertToPhonetic(txtInputValue);
				txtConvertedVal.setText(conversionService.getConvertedValue());
				
			}
		});
		btnConvert.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnConvert.setBounds(344, 266, 124, 32);
		panel.add(btnConvert);
		
		JLabel lblCopyImg = new JLabel("img");
		lblCopyImg.setBorder(new MatteBorder(2, 3, 2, 3, (Color) new Color(0, 0, 0)));
		lblCopyImg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCopyImg.setToolTipText("copy");
		lblCopyImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String convertedValue = txtConvertedVal.getText();
				
				ClipBoardCopyService clipBoardCopyService = new ClipBoardCopyService();
				clipBoardCopyService.copyToClipBoard(convertedValue);
				
				JOptionPane.showMessageDialog(null, "Phonetics succesfully copied!");
				
			}
		});
		lblCopyImg.setIcon(new ImageIcon("D:\\Zamora, Lawrence Earl\\workspace\\PhoneticConversionTool\\icon\\copyIcon.png"));
		lblCopyImg.setBounds(444, 187, 47, 46);
		panel.add(lblCopyImg);
	}
}
