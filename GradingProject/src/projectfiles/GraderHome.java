package projectfiles;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class GraderHome {

	private JFrame frame;
	private JTextField nameTextField;
	private JTextField credTextField;
	private JTextField critTextField1;
	private JTextField percent;
	private JTextField ptsReceived;
	private JTextField ptsPossible;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraderHome window = new GraderHome();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GraderHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Parser grader = new Parser();
		GradingCatController critController = new GradingCatController();
		AssignmentController assignmentController = new AssignmentController();
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 849, 604);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JList<Assignment> assignmentList = new JList<>(assignmentController.getAssignments());
		assignmentList.setBounds(457, 306, 270, 178);
		frame.getContentPane().add(assignmentList);
		
		JList<GradingCategory> gradingCrit = new JList<>(critController.getCriteria());
		gradingCrit.setBounds(457, 92, 270, 188);
		frame.getContentPane().add(gradingCrit);
		
		JLabel lblAddedAssignments = new JLabel("Added Assignments");
		lblAddedAssignments.setBounds(538, 286, 120, 14);
		lblAddedAssignments.setLabelFor(lblAddedAssignments);
		frame.getContentPane().add(lblAddedAssignments);
		
		JLabel lblGradingCriteria = new JLabel("Grading Criteria");
		lblGradingCriteria.setBounds(549, 72, 90, 14);
		lblGradingCriteria.setLabelFor(gradingCrit);
		frame.getContentPane().add(lblGradingCriteria);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(157, 90, 169, 20);
		frame.getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel lblName = new JLabel("Class Name:");
		lblName.setBounds(75, 93, 75, 14);
		lblName.setLabelFor(nameTextField);
		frame.getContentPane().add(lblName);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Automatic Grader!");
		lblWelcomeToThe.setBounds(251, 0, 324, 40);
		lblWelcomeToThe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(lblWelcomeToThe);
		
		JLabel lblPleaseEnterYour = new JLabel("Please enter your info in the displayed fields.");
		lblPleaseEnterYour.setBounds(290, 37, 300, 14);
		frame.getContentPane().add(lblPleaseEnterYour);
		
		credTextField = new JTextField();
		credTextField.setBounds(138, 118, 33, 20);
		frame.getContentPane().add(credTextField);
		credTextField.setColumns(10);
		
		JLabel lblCredits = new JLabel("Credits:");
		lblCredits.setBounds(75, 121, 50, 14);
		lblCredits.setLabelFor(credTextField);
		frame.getContentPane().add(lblCredits);
		
		JButton btnSubmitInfo = new JButton("Submit your info!");
		btnSubmitInfo.setBounds(335, 521, 130, 23);
		btnSubmitInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(critController.check100()) {
					try {
						String className = nameTextField.getText();
						double credits = Double.parseDouble(credTextField.getText());
						grader.changeCredits(credits);
						grader.changeName(className);
						//print out final result from the Calculations
						Calculations calculator = new Calculations(grader);
						System.out.println("Grade for " + grader.className +": " + calculator.finalCalculation() + "% " + calculator.letterGrade());	
					}
					catch(Exception exception) {
						System.out.println("Credits field is not a number.");
					}
				}
				else {
					System.out.println("Your grading criteria do not add up to 100%");
				}
			}
		});
		frame.getContentPane().add(btnSubmitInfo);
		
		JLabel lblGradingCriterioneg = new JLabel("Grading Criteria (e.g. Quizzes, 10%)");
		lblGradingCriterioneg.setBounds(60, 187, 363, 20);
		lblGradingCriterioneg.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(lblGradingCriterioneg);
		
		JLabel lblCriterion = new JLabel("Criterion:");
		lblCriterion.setBounds(75, 221, 60, 14);
		frame.getContentPane().add(lblCriterion);
		
		critTextField1 = new JTextField();
		critTextField1.setBounds(143, 218, 159, 20);
		frame.getContentPane().add(critTextField1);
		critTextField1.setColumns(10);
		
		JLabel lblPercentage = new JLabel("Percentage:");
		lblPercentage.setBounds(75, 247, 70, 14);
		frame.getContentPane().add(lblPercentage);
		
		percent = new JTextField();
		percent.setBounds(153, 244, 49, 20);
		frame.getContentPane().add(percent);
		percent.setColumns(10);
		
		JLabel label = new JLabel("%");
		label.setBounds(212, 247, 11, 14);
		frame.getContentPane().add(label);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(75, 282, 60, 23);
		frame.getContentPane().add(btnAdd);
		
		JLabel lblAssignment = new JLabel("Assignments (e.g. Exams, 95/100)");
		lblAssignment.setBounds(59, 340, 353, 20);
		lblAssignment.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(lblAssignment);
		
		JLabel lblGradingCriterion = new JLabel("Grading criterion:");
		lblGradingCriterion.setBounds(75, 379, 100, 14);
		frame.getContentPane().add(lblGradingCriterion);
		
		JLabel lblPointsReceived = new JLabel("Points received:");
		lblPointsReceived.setBounds(75, 414, 100, 14);
		frame.getContentPane().add(lblPointsReceived);
		
		JLabel lblPointsPossible = new JLabel("Points possible:");
		lblPointsPossible.setBounds(75, 452, 100, 14);
		frame.getContentPane().add(lblPointsPossible);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(189, 375, 159, 22);
		comboBox.setToolTipText("");
		frame.getContentPane().add(comboBox);		 
		
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String criterionName = critTextField1.getText();
				int percentage = Integer.parseInt(percent.getText());
				GradingCategory cat = new GradingCategory(criterionName, percentage);
				grader.addCategory(cat);
				critController.addCriterion(cat);
				comboBox.addItem(cat.name);
			}
		});	
		
		ptsReceived = new JTextField();
		ptsReceived.setBounds(179, 411, 55, 20);
		frame.getContentPane().add(ptsReceived);
		ptsReceived.setColumns(10);
		
		ptsPossible = new JTextField();
		ptsPossible.setBounds(179, 449, 55, 20);
		frame.getContentPane().add(ptsPossible);
		ptsPossible.setColumns(10);
		
	
		
		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.setBounds(75, 494, 60, 23);
		btnAdd_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String criterionName = (String) comboBox.getSelectedItem();
				try {
					double pntsPoss = Double.parseDouble(ptsPossible.getText());
					double pntsGot = Double.parseDouble(ptsReceived.getText());
					if(pntsPoss!=0) {
						Assignment a = new Assignment(pntsGot, pntsPoss, grader.getCategory(criterionName));
						assignmentController.addAssignment(a);					
					}
					else {
						System.out.println("Your assignment cannot be out of 0 points.");
					}				
				}
				//sanitize input
				catch (Exception e) {
					System.out.println("Invalid input. Make sure field isn't left blank and that number values are used if necessary.");
				}
			}
		});
		frame.getContentPane().add(btnAdd_1);
		

	}
}
