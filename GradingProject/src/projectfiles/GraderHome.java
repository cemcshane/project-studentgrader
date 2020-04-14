package projectfiles;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GraderHome {

	private JFrame frame;
	private JTextField nameTextField;
	private JTextField credTextField;
	private JTextField critTextField1;
	private JTextField percent;
	private JTextField critTextField2;
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
		frame.setBounds(100, 100, 849, 604);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JList assignmentList = new JList(assignmentController.getAssignments());
		springLayout.putConstraint(SpringLayout.SOUTH, assignmentList, -83, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, assignmentList, -108, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(assignmentList);
		
		JList gradingCrit = new JList(critController.getCriteria());
		springLayout.putConstraint(SpringLayout.EAST, gradingCrit, -108, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, assignmentList, 0, SpringLayout.WEST, gradingCrit);
		springLayout.putConstraint(SpringLayout.SOUTH, gradingCrit, -287, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(gradingCrit);
		
		JLabel lblAddedAssignments = new JLabel("Added Assignments");
		springLayout.putConstraint(SpringLayout.NORTH, assignmentList, 6, SpringLayout.SOUTH, lblAddedAssignments);
		springLayout.putConstraint(SpringLayout.NORTH, lblAddedAssignments, 6, SpringLayout.SOUTH, gradingCrit);
		springLayout.putConstraint(SpringLayout.EAST, lblAddedAssignments, -164, SpringLayout.EAST, frame.getContentPane());
		lblAddedAssignments.setLabelFor(lblAddedAssignments);
		frame.getContentPane().add(lblAddedAssignments);
		
		JLabel lblGradingCriteria = new JLabel("Grading Criteria");
		springLayout.putConstraint(SpringLayout.NORTH, gradingCrit, 4, SpringLayout.SOUTH, lblGradingCriteria);
		lblGradingCriteria.setLabelFor(gradingCrit);
		springLayout.putConstraint(SpringLayout.EAST, lblGradingCriteria, -178, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(lblGradingCriteria);
		
		nameTextField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, nameTextField, -2, SpringLayout.NORTH, gradingCrit);
		springLayout.putConstraint(SpringLayout.EAST, nameTextField, -145, SpringLayout.WEST, gradingCrit);
		frame.getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel lblName = new JLabel("Class Name:");
		springLayout.putConstraint(SpringLayout.WEST, nameTextField, 6, SpringLayout.EAST, lblName);
		springLayout.putConstraint(SpringLayout.NORTH, lblName, 1, SpringLayout.NORTH, gradingCrit);
		lblName.setLabelFor(nameTextField);
		frame.getContentPane().add(lblName);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Automatic Grader!");
		springLayout.putConstraint(SpringLayout.NORTH, lblWelcomeToThe, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblWelcomeToThe, 251, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblWelcomeToThe, 40, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblWelcomeToThe, -260, SpringLayout.EAST, frame.getContentPane());
		lblWelcomeToThe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(lblWelcomeToThe);
		
		JLabel lblPleaseEnterYour = new JLabel("Please enter your info in the displayed fields.");
		springLayout.putConstraint(SpringLayout.NORTH, lblGradingCriteria, 18, SpringLayout.SOUTH, lblPleaseEnterYour);
		springLayout.putConstraint(SpringLayout.NORTH, lblPleaseEnterYour, 2, SpringLayout.SOUTH, lblWelcomeToThe);
		springLayout.putConstraint(SpringLayout.WEST, lblPleaseEnterYour, 0, SpringLayout.WEST, lblWelcomeToThe);
		frame.getContentPane().add(lblPleaseEnterYour);
		
		credTextField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, credTextField, 8, SpringLayout.SOUTH, nameTextField);
		springLayout.putConstraint(SpringLayout.WEST, credTextField, 119, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, credTextField, -305, SpringLayout.WEST, gradingCrit);
		frame.getContentPane().add(credTextField);
		credTextField.setColumns(10);
		
		JLabel lblCredits = new JLabel("Credits:");
		springLayout.putConstraint(SpringLayout.EAST, lblCredits, -5, SpringLayout.WEST, credTextField);
		springLayout.putConstraint(SpringLayout.WEST, lblName, 0, SpringLayout.WEST, lblCredits);
		springLayout.putConstraint(SpringLayout.NORTH, lblCredits, 3, SpringLayout.NORTH, credTextField);
		lblCredits.setLabelFor(credTextField);
		frame.getContentPane().add(lblCredits);
		
		JButton btnSubmitInfo = new JButton("Submit your info!");
		btnSubmitInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String className = nameTextField.getText();
				double credits = Double.parseDouble(credTextField.getText());
				grader.changeCredits(credits);
				grader.changeName(className);
				System.out.println(grader.toString());
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnSubmitInfo, -23, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(btnSubmitInfo);
		
		JLabel lblGradingCriterioneg = new JLabel("Grading Criteria (e.g. Quizzes, 10%)");
		springLayout.putConstraint(SpringLayout.WEST, gradingCrit, 106, SpringLayout.EAST, lblGradingCriterioneg);
		springLayout.putConstraint(SpringLayout.WEST, lblGradingCriterioneg, 60, SpringLayout.WEST, frame.getContentPane());
		lblGradingCriterioneg.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(lblGradingCriterioneg);
		
		JLabel lblCriterion = new JLabel("Criterion:");
		frame.getContentPane().add(lblCriterion);
		
		critTextField1 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, critTextField1, 132, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblCriterion, -6, SpringLayout.WEST, critTextField1);
		springLayout.putConstraint(SpringLayout.NORTH, critTextField1, 218, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblGradingCriterioneg, -11, SpringLayout.NORTH, critTextField1);
		springLayout.putConstraint(SpringLayout.EAST, critTextField1, -166, SpringLayout.WEST, gradingCrit);
		springLayout.putConstraint(SpringLayout.NORTH, lblCriterion, 3, SpringLayout.NORTH, critTextField1);
		frame.getContentPane().add(critTextField1);
		critTextField1.setColumns(10);
		
		JLabel lblPercentage = new JLabel("Percentage:");
		frame.getContentPane().add(lblPercentage);
		
		percent = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lblPercentage, 3, SpringLayout.NORTH, percent);
		springLayout.putConstraint(SpringLayout.EAST, lblPercentage, -3, SpringLayout.WEST, percent);
		springLayout.putConstraint(SpringLayout.NORTH, percent, 6, SpringLayout.SOUTH, critTextField1);
		springLayout.putConstraint(SpringLayout.WEST, percent, 145, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(percent);
		percent.setColumns(10);
		
		JLabel label = new JLabel("%");
		springLayout.putConstraint(SpringLayout.EAST, percent, -6, SpringLayout.WEST, label);
		springLayout.putConstraint(SpringLayout.NORTH, label, 6, SpringLayout.SOUTH, critTextField1);
		springLayout.putConstraint(SpringLayout.WEST, label, 200, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(label);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String criterionName = critTextField1.getText();
				int percentage = Integer.parseInt(percent.getText());
				grader.addCategory(new GradingCategory(criterionName, percentage));
				critController.addCriterion(new GradingCategory(criterionName, percentage));
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnAdd, -3, SpringLayout.NORTH, assignmentList);
		springLayout.putConstraint(SpringLayout.WEST, btnAdd, 59, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnAdd);
		
		JLabel lblAssignment = new JLabel("Assignments (e.g. Exams, 95/100)");
		springLayout.putConstraint(SpringLayout.WEST, lblAssignment, 59, SpringLayout.WEST, frame.getContentPane());
		lblAssignment.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(lblAssignment);
		
		JLabel lblGradingCriterion = new JLabel("Grading criterion:");
		springLayout.putConstraint(SpringLayout.WEST, lblGradingCriterion, 0, SpringLayout.WEST, lblName);
		frame.getContentPane().add(lblGradingCriterion);
		
		critTextField2 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lblGradingCriterion, 3, SpringLayout.NORTH, critTextField2);
		springLayout.putConstraint(SpringLayout.WEST, critTextField2, 190, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblAssignment, -16, SpringLayout.NORTH, critTextField2);
		springLayout.putConstraint(SpringLayout.NORTH, critTextField2, 376, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, critTextField2, -16, SpringLayout.EAST, lblGradingCriterioneg);
		frame.getContentPane().add(critTextField2);
		critTextField2.setColumns(10);
		
		JLabel lblPointsReceived = new JLabel("Points received:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPointsReceived, 13, SpringLayout.SOUTH, lblGradingCriterion);
		springLayout.putConstraint(SpringLayout.WEST, lblPointsReceived, 0, SpringLayout.WEST, lblName);
		frame.getContentPane().add(lblPointsReceived);
		
		JLabel lblPointsPossible = new JLabel("Points possible:");
		springLayout.putConstraint(SpringLayout.WEST, lblPointsPossible, 0, SpringLayout.WEST, lblName);
		springLayout.putConstraint(SpringLayout.SOUTH, lblPointsPossible, 0, SpringLayout.SOUTH, assignmentList);
		frame.getContentPane().add(lblPointsPossible);
		
		ptsReceived = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, ptsReceived, 7, SpringLayout.SOUTH, critTextField2);
		springLayout.putConstraint(SpringLayout.WEST, ptsReceived, 6, SpringLayout.EAST, lblPointsReceived);
		springLayout.putConstraint(SpringLayout.EAST, ptsReceived, 61, SpringLayout.EAST, lblPointsReceived);
		frame.getContentPane().add(ptsReceived);
		ptsReceived.setColumns(10);
		
		ptsPossible = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, ptsPossible, -3, SpringLayout.NORTH, lblPointsPossible);
		springLayout.putConstraint(SpringLayout.WEST, ptsPossible, 6, SpringLayout.EAST, lblPointsPossible);
		springLayout.putConstraint(SpringLayout.EAST, ptsPossible, 61, SpringLayout.EAST, lblPointsPossible);
		frame.getContentPane().add(ptsPossible);
		ptsPossible.setColumns(10);
		
		JButton btnAdd_1 = new JButton("Add");
		springLayout.putConstraint(SpringLayout.WEST, btnSubmitInfo, 209, SpringLayout.EAST, btnAdd_1);
		btnAdd_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String criterionName = critTextField2.getText();
				double pntsPoss = Double.parseDouble(ptsPossible.getText());
				double pntsGot = Double.parseDouble(ptsReceived.getText());
				Assignment a = new Assignment(pntsGot, pntsPoss, grader.getCategory(criterionName));
				assignmentController.addAssignment(a);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnAdd_1, 18, SpringLayout.SOUTH, lblPointsPossible);
		springLayout.putConstraint(SpringLayout.WEST, btnAdd_1, 0, SpringLayout.WEST, lblName);
		frame.getContentPane().add(btnAdd_1);
	}
}
