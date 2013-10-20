package com.efgonzalez.cs165.calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class MainWindow extends javax.swing.JFrame implements
		BtnPressedListener {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	private static final long serialVersionUID = 1L;
	private JLabel calcDisplay;
	private JPanel numPadContainer;
	private JPanel operatorContainer;
	private JButton btnOpMultiply, btnOpDivide, btnOpMinus, btnOpPlus,
			btnOpEnter, btnOpUndo;
	private JButton btnNum0, btnNum1, btnNum2, btnNum3, btnNum4, btnNum5,
			btnNum6, btnNum7, btnNum8, btnNum9;
	private JButton btnSpacer;
	private JMenuBar calcMenuBar;
	private JMenu calcFileMenu;
	private JMenuItem saveXml, saveTxt;
	private Calculator c = new Calculator();
	private CalculatorInvoker i = new CalculatorInvoker(c);

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainWindow inst = new MainWindow();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public MainWindow() {
		super();
		initGUI();
		c.addBtnPressedListener(this);
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				calcMenuBar = new JMenuBar();
				setJMenuBar(calcMenuBar);
				{
					calcFileMenu = new JMenu();
					calcMenuBar.add(calcFileMenu);
					calcFileMenu.setText("File");
					{
						saveTxt = new JMenuItem();
						calcFileMenu.add(saveTxt);
						saveTxt.setText("Save Log [TXT]");
						saveTxt.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								saveTxtActionPerformed(evt);
							}
						});
					}
					{
						saveXml = new JMenuItem();
						calcFileMenu.add(saveXml);
						saveXml.setText("Save Log [XML]");
						saveXml.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								saveXmlActionPerformed(evt);
							}
						});
					}
				}
			}
			{
				calcDisplay = new JLabel();
				BorderLayout calcDisplayLayout = new BorderLayout();
				calcDisplay.setLayout(calcDisplayLayout);
				getContentPane().add(calcDisplay, "North");
				calcDisplay.setText("");
				calcDisplay.setBounds(0, 0, 444, 56);
				calcDisplay.setFont(new java.awt.Font("Courier New", 0, 24));
				calcDisplay.setBackground(new java.awt.Color(0, 0, 0));
				calcDisplay.setForeground(new java.awt.Color(0, 255, 0));
				calcDisplay.setOpaque(true);
				calcDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
				calcDisplay.setHorizontalTextPosition(SwingConstants.RIGHT);
			}
			{
				numPadContainer = new JPanel();
				GridLayout buttonContainerLayout = new GridLayout(4, 3);
				buttonContainerLayout.setColumns(1);
				buttonContainerLayout.setHgap(5);
				buttonContainerLayout.setVgap(5);
				numPadContainer.setLayout(buttonContainerLayout);
				getContentPane().add(numPadContainer);
				numPadContainer.setBounds(0, 56, 302, 222);
				{
					btnNum7 = new JButton();
					numPadContainer.add(btnNum7);
					btnNum7.setText("7");
					btnNum7.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnNum7ActionPerformed(evt);
						}
					});
				}
				{
					btnNum8 = new JButton();
					numPadContainer.add(btnNum8);
					btnNum8.setText("8");
					btnNum8.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnNum8ActionPerformed(evt);
						}
					});
				}
				{
					btnNum9 = new JButton();
					numPadContainer.add(btnNum9);
					btnNum9.setText("9");
					btnNum9.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnNum9ActionPerformed(evt);
						}
					});
				}
				{
					btnNum4 = new JButton();
					numPadContainer.add(btnNum4);
					btnNum4.setText("4");
					btnNum4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnNum4ActionPerformed(evt);
						}
					});
				}
				{
					btnNum5 = new JButton();
					numPadContainer.add(btnNum5);
					btnNum5.setText("5");
					btnNum5.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnNum5ActionPerformed(evt);
						}
					});
				}
				{
					btnNum6 = new JButton();
					numPadContainer.add(btnNum6);
					btnNum6.setText("6");
					btnNum6.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnNum6ActionPerformed(evt);
						}
					});
				}
				{
					btnNum1 = new JButton();
					numPadContainer.add(btnNum1);
					btnNum1.setText("1");
					btnNum1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnNum1ActionPerformed(evt);
						}
					});
				}
				{
					btnNum2 = new JButton();
					numPadContainer.add(btnNum2);
					btnNum2.setText("2");
					btnNum2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnNum2ActionPerformed(evt);
						}
					});
				}
				{
					btnNum3 = new JButton();
					numPadContainer.add(btnNum3);
					btnNum3.setText("3");
					btnNum3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnNum3ActionPerformed(evt);
						}
					});
				}
				{
					btnOpUndo = new JButton();
					numPadContainer.add(btnOpUndo);
					btnOpUndo.setText("Undo");
					btnOpUndo.setBackground(new java.awt.Color(0,0,255));
					btnOpUndo.setForeground(new java.awt.Color(255,255,255));
					btnOpUndo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnNumDecimalActionPerformed(evt);
						}
					});
				}
				{
					btnNum0 = new JButton();
					numPadContainer.add(btnNum0);
					btnNum0.setText("0");
					btnNum0.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnNum0ActionPerformed(evt);
						}
					});
				}
				{
					btnSpacer = new JButton();
					numPadContainer.add(btnSpacer);
					btnSpacer.setEnabled(false);
					btnSpacer.setBorderPainted(false);
				}
			}
			{
				operatorContainer = new JPanel();
				GridLayout operatorContainerLayout = new GridLayout(5, 1);
				operatorContainerLayout.setColumns(1);
				operatorContainerLayout.setHgap(5);
				operatorContainerLayout.setVgap(5);
				getContentPane().add(operatorContainer);
				operatorContainer.setLayout(operatorContainerLayout);
				operatorContainer.setBounds(314, 56, 130, 222);
				{
					btnOpPlus = new JButton();
					operatorContainer.add(btnOpPlus);
					btnOpPlus.setText("+");
					btnOpPlus.setBackground(new java.awt.Color(255, 127, 0));
					btnOpPlus.setFont(new java.awt.Font("Dialog", 1, 16));
					btnOpPlus.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnOpPlusActionPerformed(evt);
						}
					});
				}
				{
					btnOpMinus = new JButton();
					operatorContainer.add(btnOpMinus);
					btnOpMinus.setText("-");
					btnOpMinus.setBackground(new java.awt.Color(255, 127, 0));
					btnOpMinus.setFont(new java.awt.Font("Dialog", 1, 16));
					btnOpMinus.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnOpMinusActionPerformed(evt);
						}
					});
				}
				{
					btnOpDivide = new JButton();
					operatorContainer.add(btnOpDivide);
					btnOpDivide.setText("÷");
					btnOpDivide.setBackground(new java.awt.Color(255, 127, 0));
					btnOpDivide.setFont(new java.awt.Font("Dialog", 1, 16));
					btnOpDivide.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnOpDivideActionPerformed(evt);
						}
					});
				}
				{
					btnOpMultiply = new JButton();
					operatorContainer.add(btnOpMultiply);
					btnOpMultiply.setText("×");
					btnOpMultiply
							.setBackground(new java.awt.Color(255, 127, 0));
					btnOpMultiply.setFont(new java.awt.Font("Dialog", 1, 16));
					btnOpMultiply.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnOpMultiplyActionPerformed(evt);
						}
					});
				}
				{
					btnOpEnter = new JButton();
					operatorContainer.add(btnOpEnter);
					btnOpEnter.setText("Enter");
					btnOpEnter.setBackground(new java.awt.Color(255, 127, 0));
					btnOpEnter.setFont(new java.awt.Font("Dialog", 1, 16));
					btnOpEnter.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnOpEnterActionPerformed(evt);
						}
					});
				}
			}
			pack();
			this.setSize(444, 325);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void btnPressed(Calculator sender) {
		// Update display when button is pressed
		calcDisplay.setText(sender.getDisplay().toString());
	}

	private void btnNum0ActionPerformed(ActionEvent evt) {
		i.updateOperand(0);
	}

	private void btnNum1ActionPerformed(ActionEvent evt) {
		i.updateOperand(1);
	}

	private void btnNum2ActionPerformed(ActionEvent evt) {
		i.updateOperand(2);
	}

	private void btnNum3ActionPerformed(ActionEvent evt) {
		i.updateOperand(3);
	}

	private void btnNum4ActionPerformed(ActionEvent evt) {
		i.updateOperand(4);
	}

	private void btnNum5ActionPerformed(ActionEvent evt) {
		i.updateOperand(5);
	}

	private void btnNum6ActionPerformed(ActionEvent evt) {
		i.updateOperand(6);
	}

	private void btnNum7ActionPerformed(ActionEvent evt) {
		i.updateOperand(7);
	}

	private void btnNum8ActionPerformed(ActionEvent evt) {
		i.updateOperand(8);
	}

	private void btnNum9ActionPerformed(ActionEvent evt) {
		i.updateOperand(9);
	}

	private void btnOpPlusActionPerformed(ActionEvent evt) {
		i.updateOperator('+');
	}

	private void btnOpMinusActionPerformed(ActionEvent evt) {
		i.updateOperator('-');
	}

	private void btnOpDivideActionPerformed(ActionEvent evt) {
		i.updateOperator('÷');
	}

	private void btnOpMultiplyActionPerformed(ActionEvent evt) {
		i.updateOperator('×');
	}

	private void btnOpEnterActionPerformed(ActionEvent evt) {
		i.compute();
	}

	private void btnNumDecimalActionPerformed(ActionEvent evt) {
		i.undo();
	}

	private void saveTxtActionPerformed(ActionEvent evt) {
		i.setStrategy(new SaveLogPlainTextStrategy());
		i.saveLog();
	}

	private void saveXmlActionPerformed(ActionEvent evt) {
		i.setStrategy(new SaveLogXmlStrategy());
		i.saveLog();
	}
}
