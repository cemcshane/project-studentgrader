package projectfiles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.PopupFactory;

import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class GraderHome {

	private JFrame frame;
	private JTextField nameTextField;
	private JTextField credTextField;
	private JTextField critTextField1;
	private JTextField percent;
	private JTextField ptsReceived;
	private JTextField ptsPossible;
	private Popup alert;

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
		PopupFactory pFactory = new PopupFactory();
		JPanel popPanel = new JPanel(new BorderLayout());
		popPanel.setBackground(new Color(200, 200, 200));
		JLabel popLabel = new JLabel("Insert alert string");
		JButton popButton = new JButton("OK");
		DecimalFormat df = new DecimalFormat("0.00");
		Parser grader = new Parser();
		Semester semester = new Semester();
		GradingCatController critController = new GradingCatController();
		AssignmentController assignmentController = new AssignmentController();
		GradeController gradeController = new GradeController();
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 849, 704);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(498, 311, 270, 97);
		frame.getContentPane().add(scrollPane_1);
		
		
		
		JList<Assignment> assignmentList = new JList<>(assignmentController.getAssignments());
		scrollPane_1.setViewportView(assignmentList);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(498, 130, 270, 97);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblGradingCriteria = new JLabel("Grade Breakdown");
		lblGradingCriteria.setBounds(590, 110, 151, 14);
		frame.getContentPane().add(lblGradingCriteria);		
		
		JList<GradingCategory> gradingCrit = new JList<>(critController.getCriteria());
		scrollPane.setViewportView(gradingCrit);
		lblGradingCriteria.setLabelFor(gradingCrit);
		
		JLabel lblAddedAssignments = new JLabel("Added Assignments");
		lblAddedAssignments.setBounds(579, 291, 120, 14);
		lblAddedAssignments.setLabelFor(lblAddedAssignments);
		frame.getContentPane().add(lblAddedAssignments);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(295, 62, 169, 20);
		frame.getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel lblName = new JLabel("Class Name:");
		lblName.setBounds(213, 65, 75, 14);
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
		credTextField.setBounds(557, 62, 33, 20);
		frame.getContentPane().add(credTextField);
		credTextField.setColumns(10);
		
		JLabel lblCredits = new JLabel("Credits:");
		lblCredits.setBounds(494, 65, 50, 14);
		lblCredits.setLabelFor(credTextField);
		frame.getContentPane().add(lblCredits);
		
		JLabel lblGradingCriterioneg = new JLabel("Grading Criteria (e.g. Quizzes, 10%)");
		lblGradingCriterioneg.setBounds(60, 112, 363, 20);
		lblGradingCriterioneg.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(lblGradingCriterioneg);
		
		JLabel lblCriterion = new JLabel("Criterion:");
		lblCriterion.setBounds(75, 146, 60, 14);
		frame.getContentPane().add(lblCriterion);
		
		critTextField1 = new JTextField();
		critTextField1.setBounds(143, 143, 159, 20);
		frame.getContentPane().add(critTextField1);
		critTextField1.setColumns(10);
		
		JLabel lblPercentage = new JLabel("Percentage:");
		lblPercentage.setBounds(75, 172, 83, 14);
		frame.getContentPane().add(lblPercentage);
		
		percent = new JTextField();
		percent.setBounds(153, 169, 49, 20);
		frame.getContentPane().add(percent);
		percent.setColumns(10);
		
		JLabel label = new JLabel("%");
		label.setBounds(212, 172, 11, 14);
		frame.getContentPane().add(label);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(75, 207, 60, 23);
		frame.getContentPane().add(btnAdd);
		
		JLabel lblAssignment = new JLabel("Assignments (e.g. Exams, 95/100)");
		lblAssignment.setBounds(59, 265, 353, 20);
		lblAssignment.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(lblAssignment);
		
		JLabel lblGradingCriterion = new JLabel("Grading criterion:");
		lblGradingCriterion.setBounds(75, 304, 120, 14);
		frame.getContentPane().add(lblGradingCriterion);
		
		JLabel lblPointsReceived = new JLabel("Points received:");
		lblPointsReceived.setBounds(75, 339, 100, 14);
		frame.getContentPane().add(lblPointsReceived);
		
		JLabel lblPointsPossible = new JLabel("Points possible:");
		lblPointsPossible.setBounds(75, 377, 100, 14);
		frame.getContentPane().add(lblPointsPossible);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(189, 300, 159, 22);
		comboBox.setToolTipText("");
		frame.getContentPane().add(comboBox);		
		
		JButton btnSubmitInfo = new JButton("Add course");
		btnSubmitInfo.setBounds(343, 461, 111, 23);
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
						Course course = new Course(calculator);
						semester.addCourse(course);
						String gradeString = grader.className +": " + df.format(calculator.finalCalculation()) + "% " + calculator.letterGrade();
						gradeController.addGrade(gradeString);
						grader.clear();
						critController.clear();
						assignmentController.clear();
						nameTextField.setText("");
						credTextField.setText("");
						comboBox.removeAllItems();
					}
					catch(Exception exception) {
						popLabel.setText("          Credits field is not a number.           ");
						popPanel.add(popLabel, BorderLayout.NORTH);
						popPanel.add(popButton, BorderLayout.SOUTH);
						alert = pFactory.getPopup(frame, popPanel, 425, 400);
						alert.show();
					}
				}
				else {
					popLabel.setText("          Your grading criteria do not add up to 100%          ");
					popPanel.add(popLabel, BorderLayout.NORTH);
					popPanel.add(popButton, BorderLayout.SOUTH);
					alert = pFactory.getPopup(frame, popPanel, 425, 400);
					alert.show();
				}
			}
		});
		
		frame.getContentPane().add(btnSubmitInfo);		
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String criterionName = critTextField1.getText();
					double percentage = Double.parseDouble(percent.getText());
					if(grader.getCategory(criterionName)==null) {
						GradingCategory cat = new GradingCategory(criterionName, percentage);
						grader.addCategory(cat);
						critController.addCriterion(cat);
						comboBox.addItem(cat.name);
						critTextField1.setText("");
						percent.setText("");
					}
					else {
						popLabel.setText("          This category already exists.          ");
						popPanel.add(popLabel, BorderLayout.NORTH);
						popPanel.add(popButton, BorderLayout.SOUTH);
						alert = pFactory.getPopup(frame, popPanel, 425, 400);
						alert.show();
					}
				}
				catch (Exception e){
					popLabel.setText("          Percentage is not a number.          ");
					popPanel.add(popLabel, BorderLayout.NORTH);
					popPanel.add(popButton, BorderLayout.SOUTH);
					alert = pFactory.getPopup(frame, popPanel, 425, 400);
					alert.show();
				}
			}
		});	
		
		ptsReceived = new JTextField();
		ptsReceived.setBounds(179, 336, 55, 20);
		frame.getContentPane().add(ptsReceived);
		ptsReceived.setColumns(10);
		
		ptsPossible = new JTextField();
		ptsPossible.setBounds(179, 374, 55, 20);
		frame.getContentPane().add(ptsPossible);
		ptsPossible.setColumns(10);
		
	
		
		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.setBounds(75, 419, 60, 23);
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
						ptsPossible.setText("");
						ptsReceived.setText("");
					}
					else {
						popLabel.setText("          Your assignment cannot be out of 0 points.          ");
						popPanel.add(popLabel, BorderLayout.NORTH);
						popPanel.add(popButton, BorderLayout.SOUTH);
						alert = pFactory.getPopup(frame, popPanel, 425, 400);
						alert.show();
					}				
				}
				//sanitize input
				catch (Exception e) {
					popLabel.setText("          Invalid input. Make sure field isn't left blank and that number values are used if necessary.          ");
					popPanel.add(popLabel, BorderLayout.NORTH);
					popPanel.add(popButton, BorderLayout.SOUTH);
					alert = pFactory.getPopup(frame, popPanel, 425, 400);
					alert.show();
				}
			}
		});
		frame.getContentPane().add(btnAdd_1);
		
		JButton btnDeleteAssignment = new JButton("Delete assignment");
		btnDeleteAssignment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Assignment deleteThis = assignmentList.getSelectedValue();
					grader.deleteAssignment(deleteThis);
					assignmentController.deleteAssignment(deleteThis);						
				}
				catch(Exception exc) {
					popLabel.setText("          You must select an assignment to delete.          ");
					popPanel.add(popLabel, BorderLayout.NORTH);
					popPanel.add(popButton, BorderLayout.SOUTH);
					alert = pFactory.getPopup(frame, popPanel, 425, 400);
					alert.show();
				}
		
			}
		});
		btnDeleteAssignment.setBounds(557, 419, 159, 23);
		frame.getContentPane().add(btnDeleteAssignment);
		
		JButton btnDeleteCategory = new JButton("Delete category");
		btnDeleteCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				GradingCategory deleteThis = gradingCrit.getSelectedValue();
				for(Assignment a : deleteThis.getAssignments()) {
					grader.deleteAssignment(a);
					assignmentController.deleteAssignment(a);
				}				
				grader.deleteCategory(deleteThis);
				critController.deleteCategory(deleteThis);
				comboBox.removeItem(deleteThis.name);
				}
				catch(Exception ex) {
					popLabel.setText("          You must select a category to delete.          ");
					popPanel.add(popLabel, BorderLayout.NORTH);
					popPanel.add(popButton, BorderLayout.SOUTH);
					alert = pFactory.getPopup(frame, popPanel, 425, 400);
					alert.show();
				}
			}
		});
		btnDeleteCategory.setBounds(557, 238, 159, 23);
		frame.getContentPane().add(btnDeleteCategory);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(43, 517, 380, 97);
		frame.getContentPane().add(scrollPane_2);
		
		JLabel lblMyCourses = new JLabel("My Courses & Grades");
		lblMyCourses.setBounds(171, 496, 151, 14);
		frame.getContentPane().add(lblMyCourses);		
		
		JList<String> courseList = new JList<>(gradeController.getGrades());
		scrollPane_2.setViewportView(courseList);
		lblMyCourses.setLabelFor(courseList);
		
		JLabel lblSemesterGpa = new JLabel("Semester GPA:");
		lblSemesterGpa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSemesterGpa.setBounds(491, 517, 188, 14);
		frame.getContentPane().add(lblSemesterGpa);	
		
		JLabel gpa_display = new JLabel("  ");
		lblSemesterGpa.setLabelFor(gpa_display);
		gpa_display.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gpa_display.setBounds(526, 551, 49, 34);
		frame.getContentPane().add(gpa_display);		
		
		JButton btnNewButton = new JButton("Calculate my semester GPA");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(gradeController.getGrades().isEmpty()) {
					popLabel.setText("          You have not added any courses.          ");
					popPanel.add(popLabel, BorderLayout.NORTH);
					popPanel.add(popButton, BorderLayout.SOUTH);
					alert = pFactory.getPopup(frame, popPanel, 425, 400);
					alert.show();
				}
				else {
					String gpa = df.format(semester.getGPA()) + "";
					gpa_display.setText(gpa);					
				}
			}
		});
		btnNewButton.setBounds(121, 625, 221, 23);
		frame.getContentPane().add(btnNewButton);
		
		popButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				popPanel.removeAll();
				alert.hide();
			}
		});
	}
}
