package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.animation.PauseTransition;
import javafx.scene.layout.StackPane;

public class Main extends Application {
	LinkedList<Integer> CoinsList;
	Label titleLabel;
	TextField playerOneTextField;
	TextField playerTwoTextField;
	int coinsNumber;

	@Override
	public void start(Stage primaryStage) {
		// Load the title image and set its size
		Image title = new Image("file:title.png");
		ImageView titleView = new ImageView(title);
		titleView.setFitWidth(250); // Set the width of the title image
		titleView.setFitHeight(100); // Set the height of the title image

		// Place the title image inside an HBox and add padding
		HBox titlebox = new HBox(titleView);
		titlebox.setPadding(new Insets(0, 0, 0, 210)); // Add padding to center the title image horizontally
		titlebox.setAlignment(Pos.CENTER);

		// Load the logo image and set its size
		Image image = new Image("file:logo1.jpg");
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(280); // Set the width of the logo image
		imageView.setFitHeight(280); // Set the height of the logo image

		// Place the logo image inside an HBox and add padding
		HBox imagebox = new HBox(imageView);
		imagebox.setPadding(new Insets(450, 0, 350, 0)); // Adjust vertical space for the logo
		// Create a StackPane to hold all elements
		Pane pane = new StackPane();
		// Create a "help" button
		Button about = new Button("about");

		about.setAlignment(Pos.CENTER); // Align the button to the left
		about.setPadding(new Insets(0, 0, 0, 0)); // Add padding to position the button

		//////////////// Style the button//////////////////
		about.setStyle("-fx-font-size: 20px; " + "-fx-background-color: linear-gradient(#FFD700,#6B8E23); "
				+ "-fx-font-weight: bold; " + "-fx-text-fill: #FFD700; " + "-fx-cursor: hand; "
				+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;");

		about.setOnMouseEntered(
				e -> about.setStyle("-fx-font-size: 22px; " + "-fx-background-color: linear-gradient(#6B8E23,#FFD700); "
						+ "-fx-font-weight: bold; " + "-fx-text-fill: #6B8E23; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;"));

		about.setOnMouseExited(
				e -> about.setStyle("-fx-font-size: 20px; " + "-fx-background-color: linear-gradient(#FFD700,#6B8E23); "
						+ "-fx-font-weight: bold; " + "-fx-text-fill: #FFD700; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;"));

		about.setOnAction(e -> {
			Stage hh = new Stage();
			hh.setTitle("About Game!!");

			// Load the title image and set its size
			Image title1 = new Image("file:title.png");
			ImageView titleView1 = new ImageView(title1);
			titleView1.setFitWidth(250); // Set the width of the title image
			titleView1.setFitHeight(100); // Set the height of the title image

			// Place the title image inside an HBox and add padding
			HBox titlebox1 = new HBox(titleView1);
			titlebox1.setAlignment(Pos.TOP_CENTER);
			Label label = new Label("\t\t\t\tWelcome to the optimal game strategy!");
			label.setStyle("-fx-font-size: 15px;-fx-font-weight: bold; -fx-text-fill: #FFD700;");
			Label label1 = new Label(
					"For example,if you have the following coins arranged in a row:" + "[ 4 , 15 , 7 ,  3 ,  8 , 9 ]");
			label1.setStyle("-fx-font-size: 10px;-fx-font-weight: bold; -fx-text-fill: White;");

			Label label2 = new Label("The first player will try to maximize his points.");
			label2.setStyle("-fx-font-size: 10px;-fx-font-weight: bold; -fx-text-fill: White;");

			Label label3 = new Label("The maximum number of points that the first player can achieve is: 27");
			label3.setStyle("-fx-font-size: 10px;-fx-font-weight: bold; -fx-text-fill: White;");

			Label label4 = new Label("Here's the perfect way to play:");
			label4.setStyle("-fx-font-size: 10px;-fx-font-weight: bold; -fx-text-fill: White;");

			Label label5 = new Label("1.Start by selecting the first or last coin from the remaining stack.");
			label5.setStyle("-fx-font-size: 10px;-fx-font-weight: bold; -fx-text-fill: White;");

			Label label6 = new Label("2.After you make your choice, the second player will have to choose which\n"
					+ " coin will affect future choices. So, choose the coin that gives you an advantage\n in "
					+ "the next round.");
			label6.setStyle("-fx-font-size: 10px;-fx-font-weight: bold; -fx-text-fill: White;");

			Label label7 = new Label(
					"3.Players' choices follow an ideal strategy: After you choose the first or last coin, review the\n options available to you in the next stages based on the second player's moves, and\n be prepared"
							+ "to choose the coin that keeps you ahead.");
			label7.setStyle("-fx-font-size: 10px;-fx-font-weight: bold; -fx-text-fill: White;");

			Label label8 = new Label(
					"If you follow this strategy, you will end up with the highest possible number\n\t\t\t of points,"
							+ " which is 27 points in this example.");
			label8.setStyle("-fx-font-size: 15px;-fx-font-weight: bold; -fx-text-fill: #FFD700;");

			VBox xx = new VBox(2, label, label1, label2, label3, label4, label5, label6, label7, label8);
			Button bac = new Button("back");

			bac.setStyle("-fx-font-size: 20px; " + "-fx-background-color: linear-gradient(#FFD700,#6B8E23); "
					+ "-fx-font-weight: bold; " + "-fx-text-fill: #FFD700; " + "-fx-cursor: hand; "
					+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;");

			bac.setOnMouseEntered(n -> bac
					.setStyle("-fx-font-size: 22px; " + "-fx-background-color: linear-gradient(#6B8E23,#FFD700); "
							+ "-fx-font-weight: bold; " + "-fx-text-fill: #6B8E23; " + "-fx-cursor: hand; "
							+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;"));

			bac.setOnMouseExited(n -> bac
					.setStyle("-fx-font-size: 20px; " + "-fx-background-color: linear-gradient(#FFD700,#6B8E23); "
							+ "-fx-font-weight: bold; " + "-fx-text-fill: #FFD700; " + "-fx-cursor: hand; "
							+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;"));

			bac.setOnAction(h -> {
				hh.close();
			});
			VBox yy = new VBox(10, titlebox1, xx, bac);
			yy.setPadding(new Insets(10));
			yy.setAlignment(Pos.CENTER);
			yy.setStyle("-fx-background-color: #6B8E23;");

			Scene hhScene = new Scene(yy, 570, 440);
			hh.setScene(hhScene);
			hh.show();
		});
		// Create a "Play" button
		Button play = new Button("Play");
		// HBox boxplay = new HBox(play);

		play.setAlignment(Pos.CENTER); // Align the button to the left
		play.setPadding(new Insets(0, 0, 0, 330)); // Add padding to position the button
		// boxplay.setAlignment(Pos.CENTER); // Align the button to the left
		// boxplay.setPadding(new Insets(0, 0, 0, 160));
		//////////////// Style the button//////////////////
		play.setStyle("-fx-font-size: 20px; " + "-fx-background-color: linear-gradient(#FFD700,#6B8E23); "
				+ "-fx-font-weight: bold; " + "-fx-text-fill: #FFD700; " + "-fx-cursor: hand; "
				+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;");

		play.setOnMouseEntered(
				e -> play.setStyle("-fx-font-size: 22px; " + "-fx-background-color: linear-gradient(#6B8E23,#FFD700); "
						+ "-fx-font-weight: bold; " + "-fx-text-fill: #6B8E23; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;"));

		play.setOnMouseExited(
				e -> play.setStyle("-fx-font-size: 20px; " + "-fx-background-color: linear-gradient(#FFD700,#6B8E23); "
						+ "-fx-font-weight: bold; " + "-fx-text-fill: #FFD700; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;"));

		play.setOnAction(e -> {
			// Close the current stage and open the home scene when the button is clicked
			Image gifImage = new Image("file:load.gif");
			ImageView gifView = new ImageView(gifImage);

			gifView.setFitWidth(800);
			gifView.setFitHeight(800);
			gifView.setPreserveRatio(true);

			StackPane splashPane = new StackPane(gifView);
			Scene splashScene = new Scene(splashPane, 570, 440);

			primaryStage.setScene(splashScene);
			primaryStage.setTitle("Loading...");
			primaryStage.show();

			PauseTransition delay = new PauseTransition(Duration.seconds(2));
			delay.setOnFinished(event -> {
				primaryStage.close();
				homeScane();
			});

			delay.play();

		});
		HBox bb = new HBox(5, play, about);
		bb.setAlignment(Pos.BOTTOM_RIGHT); // Align the button to the left
		bb.setPadding(new Insets(0, 20, 20, 0));
		// Add the logo and VBox to the StackPane
		pane.getChildren().addAll(imagebox, titlebox, bb);
		// Set the background color of the StackPane
		pane.setStyle("-fx-background-color: #6B8E23;"); // Olive green background

		// Create a scene with the StackPane and set its dimensions
		Scene scene = new Scene(pane, 570, 440);
		primaryStage.setScene(scene); // Set the scene to the primary stage
		primaryStage.setTitle("Coins Game"); // Set the window title
		primaryStage.setResizable(false); // Make the window size fixed
		primaryStage.show(); // Show the primary stage
	}

////////////////////////////////////////////////////////////////////
	private void homeScane() {
		// Create a new Stage (window) called 'homeScane'
		Stage homeScane = new Stage();
		homeScane.setTitle("Names of players"); // Set the title of the window

		// Create an Image and ImageView for the title and set its size
		Image title = new Image("file:title.png");
		ImageView titleView = new ImageView(title);
		titleView.setFitWidth(250); // Set the width of the title image
		titleView.setFitHeight(100); // Set the height of the title image

		// Create an HBox to hold the title image and align it to the top center
		HBox titlebox = new HBox(titleView);
		titlebox.setPadding(new Insets(5, 0, 0, 0)); // Add some padding above the title
		titlebox.setAlignment(Pos.TOP_CENTER); // Align the HBox to the top center

		// Create a StackPane for the background and set a green color
		Pane pane = new StackPane();
		pane.setStyle("-fx-background-color: #6B8E23;"); // Set the background color

		// Create another Image and ImageView for the logo and set its size
		Image image = new Image("file:logo2.jpg");
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(350); // Set the width of the logo
		imageView.setFitHeight(390); // Set the height of the logo

		// Create an HBox for the logo and set its position with padding
		HBox imagebox = new HBox(imageView);
		imagebox.setPadding(new Insets(450, 0, 230, 260)); // Adjust the position of the logo

		// Create a label for the number of coins with white text and larger font size
		Label coinsLabel = new Label("Number of coins:");
		coinsLabel.setStyle("-fx-font-size: 20px;-fx-text-fill: white;");

		// Create a TextField for user input with customized styling
		TextField coinsTextField = new TextField();
		coinsTextField.setTextFormatter(
				new TextFormatter<>(change -> change.getControlNewText().length() <= 2 ? change : null) // Limit input
																										// to 10
																										// characters
		);

		coinsTextField.setStyle("-fx-background-color: linear-gradient(to right, #FFD700, #6B8E23); " + // Gradient
																										// background
																										// color
				"-fx-background-radius: 10; " + // Rounded background corners
				"-fx-border-width: 2; " + // Border width
				"-fx-border-radius: 10; " + // Rounded border corners
				"-fx-font-weight: bold; " + // Bold font
				"-fx-text-fill: white; " + // White text color
				"-fx-font-size: 15px; " + // Font size
				"-fx-padding: 5;" // Padding inside the TextField
		);

		// Create an HBox to hold the coins label and text field
		HBox box1 = new HBox(10, coinsLabel, coinsTextField); // Add spacing of 10px between elements
		box1.setPadding(new Insets(0, 0, 0, 50)); // Add padding to the left

		// Create another label for the "Enter the coins by" section
		Label enterCoinsLabel = new Label("Enter the coins by:");
		enterCoinsLabel.setStyle("-fx-font-size: 20px;-fx-text-fill: white;"); // Style the label

		// Create three radio buttons for selecting the input method

		RadioButton fileRadio = new RadioButton("File"); // Option for "File"
		RadioButton randomRadio = new RadioButton("Random"); // Option for "Random"
		RadioButton manualRadio = new RadioButton("Manual"); // Option for "Manual"

		//////////////// Style the button//////////////////
		fileRadio.setStyle("-fx-font-size: 15px;-fx-text-fill: white;-fx-mark-color: #FFD700;");
		randomRadio.setStyle("-fx-font-size: 15px;-fx-text-fill: white;-fx-mark-color: #FFD700;");
		manualRadio.setStyle("-fx-font-size: 15px;-fx-text-fill: white;-fx-mark-color: #FFD700;");

		// Create a ToggleGroup for the radio buttons to group them together
		ToggleGroup coinsGroup = new ToggleGroup();

		// Assign the ToggleGroup to the "fileRadio" button
		fileRadio.setToggleGroup(coinsGroup);

		// Set an action when the "fileRadio" button is selected
		fileRadio.setOnAction(e -> {
			// Check if the TextField is not empty
			if (!coinsTextField.getText().isEmpty()) {
				// Parse the input from the TextField as an integer
				coinsNumber = Integer.parseInt(coinsTextField.getText().trim());

				// Check if the number of coins is even and between 6 and 16
				if (coinsNumber > 0 && coinsNumber <= 20 && coinsNumber % 2 == 0) {
					// If the fileRadio button is selected
					if (fileRadio.isSelected()) {
						// Create a FileChooser to allow the user to select a file
						FileChooser fileChooser = new FileChooser();
						fileChooser.setTitle("Choose a file"); // Set the title of the file dialog

						// Add filters for text files and all files
						fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
								new FileChooser.ExtensionFilter("All Files", "*.*"));

						// Show the file dialog and store the selected file
						File selectedFile = fileChooser.showOpenDialog(homeScane);

						// Check if a file was selected
						if (selectedFile != null) {
							CoinsList = new LinkedList<>(); // Initialize the list to store coin values

							// Use a Scanner to read the file line by line
							try (Scanner scanner = new Scanner(selectedFile)) {
								while (scanner.hasNext() && CoinsList.size() < coinsNumber) {
									String line = scanner.nextLine().trim(); // Read and trim each line
									try {
										// Parse the line as an integer
										int coin = Integer.parseInt(line);
										// Add only positive even numbers to the list
										if (coin > 0) {
											CoinsList.add(coin);
										}
									} catch (NumberFormatException e1) {
										// If the line is not a valid number, skip it and print a message
										System.out.println("Skipping invalid line: " + line);
									}
								}
							} catch (FileNotFoundException e1) {
								// Show an alert if the file is not found
								showAlert("File not found!");
								coinsGroup.selectToggle(null); // Deselect the radio buttons
								return;
							}

							// Check if the file provided enough valid coins
							if (CoinsList.size() < coinsNumber) {
								// If not enough valid coins, show an alert and deselect the radio button
								showAlert("The file does not contain enough valid coins.");
								coinsGroup.selectToggle(null);
							}
						}
					}
				} else {
					// Show an alert if the coin number is invalid
					showAlert("Number of coins should be Positive even and less than or equal 20.");
					coinsGroup.selectToggle(null); // Deselect the radio button
				}
			} else {
				// Show an alert if the TextField is empty
				showAlert("Please enter the number of coins.");
				coinsGroup.selectToggle(null); // Deselect the radio button
			}
		});

		// Assign the randomRadio button to the coinsGroup ToggleGroup
		randomRadio.setToggleGroup(coinsGroup);

		// Set an action when the "randomRadio" button is selected
		randomRadio.setOnAction(e -> {
			// Check if the TextField for the number of coins is not empty
			if (!coinsTextField.getText().isEmpty()) {
				try {
					// Parse the number of coins entered by the user
					coinsNumber = Integer.parseInt(coinsTextField.getText().trim());

					// Validate the number of coins: it should be even and between 6 and 16
					if (coinsNumber > 0 && coinsNumber <= 20 && coinsNumber % 2 == 0) {
						if (randomRadio.isSelected()) {
							// Create a new Stage (window) to enter the range for the random coins
							Stage rangeStage = new Stage();
							rangeStage.setTitle("Enter Range for Random Coins");

							// Create a label and text field for the minimum value
							Label minLabel = new Label("Minimum Value:");
							minLabel.setStyle("-fx-font-size: 15px;-fx-text-fill: white;");
							TextField minTextField = new TextField();
							minTextField.setTextFormatter(new TextFormatter<>(
									change -> change.getControlNewText().length() <= 3 ? change : null) // Limit input
																										// to 10
																										// characters
							);
							minTextField.setStyle("-fx-background-color: linear-gradient(to right, #FFD700, #6B8E23); "
									+ "-fx-background-radius: 10; -fx-font-weight: bold; -fx-font-size: 15px; -fx-text-fill: white;");
							minTextField.setPrefWidth(90);
							minTextField.setPrefHeight(25);
							HBox minBox = new HBox(10, minLabel, minTextField);
							minBox.setAlignment(Pos.CENTER);

							// Create a label and text field for the maximum value
							Label maxLabel = new Label("Maximum Value:");
							maxLabel.setStyle("-fx-font-size: 15px;-fx-text-fill: white;");
							TextField maxTextField = new TextField();
							maxTextField.setTextFormatter(new TextFormatter<>(
									change -> change.getControlNewText().length() <= 3 ? change : null) // Limit input
																										// to 10
																										// characters
							);
							maxTextField.setStyle("-fx-background-color: linear-gradient(to right, #FFD700, #6B8E23); "
									+ "-fx-background-radius: 10; -fx-font-weight: bold; -fx-font-size: 15px; -fx-text-fill: white;");
							maxTextField.setPrefWidth(90);
							maxTextField.setPrefHeight(25);
							HBox maxBox = new HBox(10, maxLabel, maxTextField);
							maxBox.setAlignment(Pos.CENTER);

							// Create a VBox layout to contain the input fields (min and max)
							VBox input = new VBox(15, minBox, maxBox);

							// Create Submit and Cancel buttons
							Button submitButton = new Button("Submit");
							submitButton.setStyle(
									"-fx-font-size: 15px; -fx-background-color: linear-gradient(to right, #FFD700, #6B8E23); "
											+ "-fx-font-weight: bold; -fx-text-fill: white;");
							// Change the button style on mouse hover
							submitButton.setOnMouseEntered(c -> submitButton.setStyle(
									" -fx-text-fill: #6B8E23;-fx-font-size: 18px; -fx-background-color: linear-gradient(to right, #6B8E23, #FFD700);"));
							submitButton.setOnMouseExited(c -> submitButton.setStyle(
									"-fx-font-size: 15px; -fx-background-color: linear-gradient(to right, #FFD700, #6B8E23); "
											+ "-fx-font-weight: bold; -fx-text-fill: white;"));

							Button cancelButton = new Button("Cancel");
							cancelButton.setStyle(
									"-fx-font-size: 15px; -fx-background-color: linear-gradient(to right, #FFD700, #6B8E23); "
											+ "-fx-font-weight: bold; -fx-text-fill: white;");
							cancelButton.setOnMouseEntered(c -> cancelButton.setStyle(
									"-fx-text-fill: #6B8E23;-fx-font-size: 18px; -fx-background-color: linear-gradient(to right, #6B8E23, #FFD700);"));
							cancelButton.setOnMouseExited(c -> cancelButton.setStyle(
									"-fx-font-size: 15px; -fx-background-color: linear-gradient(to right, #FFD700, #6B8E23); "
											+ "-fx-font-weight: bold; -fx-text-fill: white;"));

							// Place the buttons in a HBox
							HBox buttonBox = new HBox(15, submitButton, cancelButton);
							buttonBox.setAlignment(Pos.CENTER);

							// Create a VBox layout for the whole range input interface
							VBox layout = new VBox(40, input, buttonBox);
							layout.setPadding(new Insets(10));
							layout.setAlignment(Pos.CENTER);
							layout.setStyle("-fx-background-color: #6B8E23;");

							// Create a Scene for the rangeStage
							Scene rangeScene = new Scene(layout, 300, 250);
							rangeStage.setScene(rangeScene);

							// Set the action for the Submit button
							submitButton.setOnAction(event -> {
								try {
									// Parse the minimum and maximum values from the text fields
									int min = Integer.parseInt(minTextField.getText());
									int max = Integer.parseInt(maxTextField.getText());

									// Validate the range (max > min)
									if (min >= 0 && max > min) {
										CoinsList = new LinkedList<>(); // Clear the previous list
										Random random = new Random();

										// Generate random coins within the specified range
										for (int i = 0; i < coinsNumber; i++) {
											int coin = random.nextInt(max - min + 1) + min; // Generate a random number
											CoinsList.add(coin);
										}

										rangeStage.close(); // Close the range selection stage
									} else {
										showAlert("The maximum value must be greater than the minimum value.");
									}
								} catch (NumberFormatException ex) {
									showAlert("Please enter valid numeric values for minimum and maximum.");
								}
							});

							// Set the action for the Cancel button
							cancelButton.setOnAction(event ->{
								coinsGroup.selectToggle(null); // Deselect the radio buttons
								rangeStage.close();
							});

							// Show the range input stage
							rangeStage.showAndWait();
						}
					} else {
						// Show an alert if the number of coins is invalid
						showAlert("Number of coins should be Positive even and less than or equal 20.");
						coinsGroup.selectToggle(null); // Deselect the radio button
					}
				} catch (NumberFormatException ex) {
					// Show an alert if the user entered an invalid number for coins
					showAlert("Please enter a valid number for coins.");
					coinsGroup.selectToggle(null); // Deselect the radio button
				}
			} else {
				// Show an alert if the user did not enter a number of coins
				showAlert("Please enter the number of coins.");
				coinsGroup.selectToggle(null); // Deselect the radio button
			}
		});

		// Set the toggle group for the manual coin insertion radio button
		manualRadio.setToggleGroup(coinsGroup);

		// Create a VBox for manual coin inputs and initially hide it
		VBox manualFieldsBox = new VBox(10);
		manualFieldsBox.setVisible(false);

		// When the manual radio button is selected, this action will trigger
		manualRadio.setOnAction(e -> {
			// Check if the user has entered the number of coins
			if (!coinsTextField.getText().isEmpty()) {
				// Convert the input number of coins to an integer
				coinsNumber = Integer.parseInt(coinsTextField.getText().trim());

				// Validate that the number of coins is even and between 6 and 16
				if (coinsNumber > 0 && coinsNumber <= 20 && coinsNumber % 2 == 0) {

					// Create a new list to store the coin values
					CoinsList = new LinkedList<>();
					// Loop to ask the user to enter each coin value
					for (int i = 1; i <= coinsNumber; i++) {
						// Show a prompt for the user to enter each coin number
						Integer userCoin = showManualInputStage("Please enter coin number " + i + ":");
						// If the user cancels, stop the process
						if (userCoin == null) {
							coinsGroup.selectToggle(null); // Deselect all radio buttons
							break;
						} else {
							// Add the entered coin value to the list
							CoinsList.add(userCoin);
						}
					}
				} else {
					// Show an error if the number of coins is not valid
					showAlert("Number of coins should be Positive even and less than or equal 20.");
					coinsGroup.selectToggle(null); // Deselect the radio buttons
				}
			} else {
				// Show an error if the number of coins was not entered
				showAlert("Please enter the number of coins.");
				coinsGroup.selectToggle(null); // Deselect the radio buttons
			}
		});

		// Create a VBox for the coin selection radio buttons and set padding
		VBox box2 = new VBox(5, enterCoinsLabel, fileRadio, randomRadio, manualRadio);
		box2.setPadding(new Insets(0, 0, 0, 50));

		// Create radio buttons for selecting the number of players
		RadioButton onePlayerRadio = new RadioButton("1-player");
		onePlayerRadio.setStyle("-fx-font-size: 15px;-fx-text-fill: white;-fx-mark-color: #FFD700;");
		RadioButton twoPlayersRadio = new RadioButton("2-players");
		twoPlayersRadio.setStyle("-fx-font-size: 15px;-fx-text-fill: white;-fx-mark-color: #FFD700;");

		// Group the player selection radio buttons together
		ToggleGroup playersGroup = new ToggleGroup();
		onePlayerRadio.setToggleGroup(playersGroup);
		twoPlayersRadio.setToggleGroup(playersGroup);

		// Create an HBox for player selection with some space between the buttons
		HBox box3 = new HBox(20, onePlayerRadio, twoPlayersRadio);
		box3.setPadding(new Insets(0, 0, 0, 80));

		// Create the OK button and apply some styles to it
		Button ok = new Button("OK");
		ok.setStyle("-fx-font-size: 15px; " + "-fx-background-color: linear-gradient(to right, #FFD700, #6B8E23);"
				+ "-fx-font-weight: bold; " + "-fx-text-fill: black; " + "-fx-cursor: hand; "
				+ "-fx-border-width: 2px; " + "-fx-padding: 2px 13px;" + "-fx-border-radius: 10px;");

		// Change the OK button style when the mouse enters or exits
		ok.setOnMouseEntered(e -> ok
				.setStyle("-fx-font-size: 18px; " + "-fx-background-color: linear-gradient(to right, #6B8E23, #FFD700);"
						+ "-fx-font-weight: bold; " + "-fx-text-fill: black; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 13px;" + "-fx-border-radius: 10px;"));

		ok.setOnMouseExited(e -> ok
				.setStyle("-fx-font-size: 15px; " + "-fx-background-color: linear-gradient(to right, #FFD700, #6B8E23);"
						+ "-fx-font-weight: bold; " + "-fx-text-fill: black; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 13px;" + "-fx-border-radius: 10px;"));

		// Align the OK button to the bottom left
		ok.setAlignment(Pos.BOTTOM_LEFT);
		Button back = new Button("Back");
		back.setStyle("-fx-font-size: 15px; " + "-fx-background-color: linear-gradient(to right, #FFD700, #6B8E23);"
				+ "-fx-font-weight: bold; " + "-fx-text-fill: black; " + "-fx-cursor: hand; "
				+ "-fx-border-width: 2px; " + "-fx-padding: 2px 13px;" + "-fx-border-radius: 10px;");

		// Change the OK button style when the mouse enters or exits
		back.setOnMouseEntered(e -> back
				.setStyle("-fx-font-size: 18px; " + "-fx-background-color: linear-gradient(to right, #6B8E23, #FFD700);"
						+ "-fx-font-weight: bold; " + "-fx-text-fill: black; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 13px;" + "-fx-border-radius: 10px;"));

		back.setOnMouseExited(e -> back
				.setStyle("-fx-font-size: 15px; " + "-fx-background-color: linear-gradient(to right, #FFD700, #6B8E23);"
						+ "-fx-font-weight: bold; " + "-fx-text-fill: black; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 13px;" + "-fx-border-radius: 10px;"));

		// Align the OK button to the bottom left
		back.setAlignment(Pos.BOTTOM_LEFT);
		back.setOnAction(e -> {
			homeScane.close();
			start(new Stage());
		});
		// Create an HBox to hold the OK button and set padding
		HBox button = new HBox(10, back, ok);
		button.setPadding(new Insets(0, 0, 0, 110));

		// Add an action to the OK button
		ok.setOnAction(e -> {
			// Check if the number of coins is entered
			if (coinsTextField.getText().isEmpty()) {
				showAlert("Please enter the number of coins.");
			}
			// Check if the user has selected how to insert the coins
			else if (coinsGroup.getSelectedToggle() == null) {
				showAlert("Please select how you want to insert coins.");
			}
			// Check if the user has selected the number of players
			else if (playersGroup.getSelectedToggle() == null) {
				showAlert("Please select the number of players.");
			} else {
				// If two players are selected, go to the two-player scene
				if (twoPlayersRadio.isSelected()) {
					homeScane.close();
					twoPlayerScane(); // Method to show two-player scene
				}
				// If one player is selected, go to the one-player scene
				if (onePlayerRadio.isSelected()) {
					homeScane.close();
					OnePlayerScane(); // Method to show one-player scene
				}
			}
		});

		// Create a VBox to hold all the boxes and set the alignment
		VBox box4 = new VBox(30, box1, box2, box3);
		box4.setAlignment(Pos.CENTER);

		// Create a VBox to hold the title and all the boxes, then add the OK button
		VBox box5 = new VBox(30, titlebox, box4, button);

		// Add all the elements to the main pane
		pane.getChildren().addAll(imagebox, box5);

		// Create the scene and set the title and size
		Scene scene = new Scene(pane, 570, 440);
		homeScane.setResizable(false);

		// Set the scene and show the home screen
		homeScane.setScene(scene);
		homeScane.setTitle("Coins Game");
		homeScane.show();
	}

	// This method shows a new stage (popup window) for manual coin input
	private Integer showManualInputStage(String message) {
		// Create a new stage (popup window) for the user input
		Stage stage = new Stage();

		// Create a label to display the message passed to the method
		Label label = new Label(message);
		label.setStyle("-fx-font-size: 15px;-fx-text-fill: white;");

		// Create a text field where the user will input the coin value
		TextField coinField = new TextField();
		coinField.setTextFormatter(
				new TextFormatter<>(change -> change.getControlNewText().length() <= 3 ? change : null) // Limit input
																										// to 10
																										// characters
		);
		coinField.setStyle("-fx-background-color: linear-gradient(to right, #FFD700, #6B8E23); "
				+ "-fx-background-radius: 10; " + "-fx-border-width: 2; " + "-fx-border-radius: 10; "
				+ "-fx-font-weight: bold; " + "-fx-text-fill: white; " + "-fx-font-size: 15px; " + "-fx-padding: 5;");
		coinField.setPromptText("Enter a positive number"); // Prompt text to guide the user

		// Create the OK button that the user will click to submit the input
		Button okButton = new Button("OK");
		okButton.setStyle("-fx-font-size:15px;" + "-fx-background-color: linear-gradient(to right, #FFD700, #6B8E23);"
				+ "-fx-font-weight: bold; " + "-fx-text-fill: white; " + "-fx-cursor: hand; "
				+ "-fx-border-width: 2px; " + "-fx-padding: 2px 13px;" + "-fx-border-radius: 10px;");

		// Change the style of the OK button when mouse enters or exits it
		okButton.setOnMouseEntered(e -> okButton
				.setStyle("-fx-font-size: 18px;" + "-fx-background-color: linear-gradient(to right, #6B8E23, #FFD700);"
						+ "-fx-font-weight: bold; " + "-fx-text-fill: white; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 13px;" + "-fx-border-radius: 10px;"));

		okButton.setOnMouseExited(e -> okButton
				.setStyle("-fx-font-size:15px;" + "-fx-background-color: linear-gradient(to right, #FFD700, #6B8E23);"
						+ "-fx-font-weight: bold; " + "-fx-text-fill: white; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 13px;" + "-fx-border-radius: 10px;"));

		// Create the Cancel button that allows the user to cancel the input
		Button cancelButton = new Button("Cancel");
		cancelButton
				.setStyle("-fx-font-size:15px;" + "-fx-background-color: linear-gradient(to right, #FFD700, #6B8E23);"
						+ "-fx-font-weight: bold; " + "-fx-text-fill: white; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 13px;" + "-fx-border-radius: 10px;");

		// Change the style of the Cancel button when mouse enters or exits it
		cancelButton.setOnMouseEntered(e -> cancelButton
				.setStyle("-fx-font-size: 18px;" + "-fx-background-color: linear-gradient(to right, #6B8E23, #FFD700);"
						+ "-fx-font-weight: bold; " + "-fx-text-fill: white; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 13px;" + "-fx-border-radius: 10px;"));

		cancelButton.setOnMouseExited(e -> cancelButton
				.setStyle("-fx-font-size:15px;" + "-fx-background-color: linear-gradient(to right, #FFD700, #6B8E23);"
						+ "-fx-font-weight: bold; " + "-fx-text-fill: white; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 13px;" + "-fx-border-radius: 10px;"));

		// Create a horizontal box (HBox) to hold the OK and Cancel buttons, with
		// spacing between them
		HBox buttonsBox = new HBox(10, okButton, cancelButton);
		buttonsBox.setAlignment(Pos.CENTER); // Align buttons to the center

		// Create a vertical box (VBox) to hold the label, coin input field, and buttons
		VBox layout = new VBox(10, label, coinField, buttonsBox);
		layout.setPadding(new Insets(15)); // Add padding around the content
		layout.setAlignment(Pos.CENTER); // Align everything in the center
		layout.setStyle("-fx-background-color: #6B8E23;"); // Set background color for the VBox

		// Define a result variable to hold the user's input
		final Integer[] result = { null };

		// Set the action for the OK button
		okButton.setOnAction(e -> {
			try {
				// Try to parse the input as an integer
				int value = Integer.parseInt(coinField.getText().trim());
				// Check if the value is positive
				if (value > 0) {
					result[0] = value; // Store the valid value in the result variable
					stage.close(); // Close the input window
				} else {
					// Show an alert if the input is not positive
					showAlert("Please enter a positive number.");
				}
			} catch (NumberFormatException ex) {
				// Show an alert if the input is not a valid number
				showAlert("Invalid input. Please enter a valid number.");
			}
		});

		// Set the action for the Cancel button
		cancelButton.setOnAction(e -> {
			stage.close(); // Close the input window without doing anything
		});

		// Set up the scene with the layout and show the stage
		Scene scene = new Scene(layout);
		stage.setScene(scene);
		stage.showAndWait(); // Wait for the user to close the stage before proceeding

		// Return the result, which is the user's input (or null if canceled)
		return result[0];
	}

////////////////////////////////////////////////////////////////////////
	// This method creates and displays a window for entering player names for a
	// two-player game
	private void twoPlayerScane() {
		// Create a new stage (popup window) for entering player names
		Stage twoPlayerScane = new Stage();
		twoPlayerScane.setTitle("Names of players"); // Set the title of the window

		// Load and display the title image at the top of the screen
		Image title = new Image("file:title.png");
		ImageView titleView = new ImageView(title);
		titleView.setFitWidth(250);
		titleView.setFitHeight(100);
		HBox titlebox = new HBox(titleView); // Wrap the image in a horizontal box (HBox)
		titlebox.setPadding(new Insets(5, 0, 0, 0)); // Set padding around the title image
		titlebox.setAlignment(Pos.TOP_CENTER); // Align the title at the top center of the screen

		// Set the background color of the main pane
		Pane pane = new StackPane();
		pane.setStyle("-fx-background-color: #6B8E23;");

		// Load and display the game logo image
		Image image = new Image("file:logo2.jpg");
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(350);
		imageView.setFitHeight(390);
		HBox imagebox = new HBox(imageView); // Wrap the image in a horizontal box
		imagebox.setPadding(new Insets(450, 0, 230, 260)); // Position the logo image within the window

		// Create a label for the first player's name input
		Label playerOneName = new Label("player One Name:");
		playerOneName.setStyle("-fx-font-size: 20px;-fx-text-fill:  #FFD700;");

		// Create a text field for player one to enter their name with a maximum length
		// of 10 characters
		playerOneTextField = new TextField();
		playerOneTextField.setStyle("-fx-background-color: linear-gradient(to right, #FFD700, #6B8E23); "
				+ "-fx-background-radius: 10; " + "-fx-border-width: 2; " + "-fx-border-radius: 10; "
				+ "-fx-font-weight: bold; " + "-fx-text-fill: white; " + "-fx-font-size: 15px; " + "-fx-padding: 5;");
		playerOneTextField.setTextFormatter(
				new TextFormatter<>(change -> change.getControlNewText().length() <= 10 ? change : null) // Limit input
																											// to 10
																											// characters
		);

		// Create a horizontal box to align the label and text field for player one
		HBox box1 = new HBox(10, playerOneName, playerOneTextField);
		box1.setAlignment(Pos.CENTER_LEFT);
		box1.setPadding(new Insets(0, 0, 0, 10)); // Add padding on the left

		// Create a label for the second player's name input
		Label playerTwoName = new Label("player Two Name:");
		playerTwoName.setStyle("-fx-font-size: 20px;-fx-text-fill:  #FFD700;");

		// Create a text field for player two to enter their name with a maximum length
		// of 10 characters
		playerTwoTextField = new TextField();
		playerTwoTextField.setStyle("-fx-background-color: linear-gradient(to right, #FFD700, #6B8E23); "
				+ "-fx-background-radius: 10; " + "-fx-border-width: 2; " + "-fx-border-radius: 10; "
				+ "-fx-font-weight: bold; " + "-fx-text-fill: white; " + "-fx-font-size: 15px; " + "-fx-padding: 5;");
		playerTwoTextField.setTextFormatter(
				new TextFormatter<>(change -> change.getControlNewText().length() <= 10 ? change : null) // Limit input
																											// to 10
																											// characters
		);

		// Create a horizontal box to align the label and text field for player two
		HBox box2 = new HBox(10, playerTwoName, playerTwoTextField);
		box2.setAlignment(Pos.CENTER_LEFT);
		box2.setPadding(new Insets(0, 0, 0, 10)); // Add padding on the left

		// Create a vertical box (VBox) to hold both player name input sections
		VBox NamesBox = new VBox(10, box1, box2);
		NamesBox.setAlignment(Pos.CENTER_LEFT);

		// Create the "Start" button that will start the game
		Button start = new Button("Start");
		start.setStyle("-fx-font-size: 20px; " + "-fx-background-color: linear-gradient(to right, #FFD700, #6B8E23);"
				+ "-fx-font-weight: bold; " + "-fx-text-fill: black; " + "-fx-cursor: hand; "
				+ "-fx-border-width: 2px; " + "-fx-padding: 2px 13px;" + "-fx-border-radius: 10px;");

		// Change the style of the "Start" button when mouse enters or exits it
		start.setOnMouseEntered(c -> start
				.setStyle("-fx-font-size: 22px; " + "-fx-background-color: linear-gradient(to right, #6B8E23, #FFD700);"
						+ "-fx-font-weight: bold; " + "-fx-text-fill: black; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 13px;" + "-fx-border-radius: 10px;"));

		start.setOnMouseExited(c -> start
				.setStyle("-fx-font-size: 20px; " + "-fx-background-color: linear-gradient(to right, #FFD700, #6B8E23);"
						+ "-fx-font-weight: bold; " + "-fx-text-fill: black; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 13px;" + "-fx-border-radius: 10px;"));

		// Set the action for the "Start" button
		start.setOnAction(e -> {
			// If any of the player names is empty, show an alert
			if (playerOneTextField.getText().isEmpty() || playerTwoTextField.getText().isEmpty()) {
				showAlert("Please Enter players' names ");
			}
			// If the players have the same name, show an alert
			if (playerOneTextField.getText().equalsIgnoreCase(playerTwoTextField.getText())) {
				showAlert("Please Enter different names ");
			} else {
				// Close the current stage and proceed to the next screen
				twoPlayerScane.close();
				twoPlayerScane2();
			}
		});

		// Create the "Back" button to go back to the previous screen
		Button back = new Button("Back");
		back.setStyle("-fx-font-size: 20px; " + "-fx-background-color: linear-gradient(to right, #FFD700, #6B8E23);"
				+ "-fx-font-weight: bold; " + "-fx-text-fill: black; " + "-fx-cursor: hand; "
				+ "-fx-border-width: 2px; " + "-fx-padding: 2px 13px;" + "-fx-border-radius: 10px;");

		// Change the style of the "Back" button when mouse enters or exits it
		back.setOnMouseEntered(c -> back
				.setStyle("-fx-font-size: 22px; " + "-fx-background-color: linear-gradient(to right, #6B8E23, #FFD700);"
						+ "-fx-font-weight: bold; " + "-fx-text-fill: black; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 13px;" + "-fx-border-radius: 10px;"));

		back.setOnMouseExited(c -> back
				.setStyle("-fx-font-size: 20px; " + "-fx-background-color: linear-gradient(to right, #FFD700, #6B8E23);"
						+ "-fx-font-weight: bold; " + "-fx-text-fill: black; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 13px;" + "-fx-border-radius: 10px;"));

		// Set the action for the "Back" button
		back.setOnAction(e -> {
			// Close the current stage and go back to the home screen
			twoPlayerScane.close();
			homeScane();
		});

		// Create a horizontal box (HBox) to align the "Back" and "Start" buttons
		HBox box3 = new HBox(20, back, start);
		box3.setAlignment(Pos.BOTTOM_LEFT);
		box3.setPadding(new Insets(0, 0, 0, 80)); // Set padding to position the buttons correctly

		// Create a vertical box (VBox) to hold the name input section and the buttons
		// at the bottom
		VBox b = new VBox(100, NamesBox, box3);
		VBox box = new VBox(60, titlebox, b); // Add the title section and the main content
		box.setAlignment(Pos.CENTER); // Center-align the entire layout

		// Add the background image and the main layout to the pane
		pane.getChildren().addAll(imagebox, box);

		// Create the scene and set it to the stage
		Scene scene = new Scene(pane, 570, 440);
		twoPlayerScane.setScene(scene);

		// Set properties for the stage
		twoPlayerScane.setTitle("Coins Game");
		twoPlayerScane.setResizable(false); // Prevent resizing the window
		twoPlayerScane.show(); // Show the stage (window)
	}

/////////////////////////////////////////////////////////////////////////
	// This method sets up the second stage (window) of the two-player game, where
	// the actual gameplay occurs.
	private void twoPlayerScane2() {
		// Create a new stage (popup window) for the two-player game
		Stage twoPlayerScane2 = new Stage();
		twoPlayerScane2.setTitle("Coins Game"); // Set the title of the window

		// Load and display the title image at the top of the screen
		Image title = new Image("file:title.png");
		ImageView titleView = new ImageView(title);
		titleView.setFitWidth(250);
		titleView.setFitHeight(100);
		HBox titlebox = new HBox(titleView); // Wrap the image in a horizontal box (HBox)
		titlebox.setPadding(new Insets(5, 0, 0, 0)); // Set padding around the title image
		titlebox.setAlignment(Pos.TOP_CENTER); // Align the title at the top center of the screen

		// Create the "Show Result" button, initially disabled
		Button resultButton = new Button("Show Result");
		resultButton.setDisable(true); // Disable the button initially

		// Create a main pane (background) for the game screen
		Pane mainPain = new StackPane();
		mainPain.setStyle("-fx-background-color: #6B8E23;"); // Set the background color of the pane

		// Create a FlowPane to arrange coin buttons
		FlowPane coinsPane = new FlowPane();
		coinsPane.setHgap(10); // Set horizontal gap between buttons
		coinsPane.setVgap(10); // Set vertical gap between buttons
		coinsPane.setAlignment(Pos.CENTER); // Align the buttons at the center of the pane

		// Create a list of buttons for each coin value, disable them initially
		LinkedList<Button> coinButtons = new LinkedList<>();
		for (Integer coinValue : CoinsList) {
			Button coinButton = new Button(coinValue.toString()); // Set the coin value as the button text
			coinButton.setStyle(
					"-fx-font-size:20px;-fx-cursor: hand;-fx-font-weight: bold; -fx-text-fill: #FFD700; -fx-background-color:none ;");
			coinButton.setDisable(true); // Disable the coin buttons initially
			coinButtons.add(coinButton); // Add the button to the coin list
			coinsPane.getChildren().add(coinButton); // Add the button to the coins pane
		}

		// Create a text field to display the score of player one, initially set to "0"
		TextField playerOneField = new TextField("0");
		playerOneField.setStyle("-fx-background-color: linear-gradient(to right, #FFD700, #6B8E23); "
				+ "-fx-background-radius: 10; " + "-fx-border-width: 2; " + "-fx-border-radius: 10; "
				+ "-fx-font-weight: bold; " + "-fx-text-fill: white; " + "-fx-font-size: 15px; " + "-fx-padding: 5;"
				+ "-fx-alignment: center;");
		playerOneField.setEditable(false); // Make the field non-editable
		playerOneField.setPrefWidth(50); // Set preferred width of the field
		playerOneField.setPrefHeight(35); // Set preferred height of the field

		// Create and display an image of player one
		Image imagePlayer1 = new Image("file:player1.jpg");
		ImageView imageViewPlaer1 = new ImageView(imagePlayer1);
		imageViewPlaer1.setFitWidth(200); // Set width of the player image
		imageViewPlaer1.setFitHeight(200); // Set height of the player image
		HBox imageboxPlayer1 = new HBox(imageViewPlaer1); // Wrap the image in a horizontal box (HBox)
		imageboxPlayer1.setPadding(new Insets(480, 410, 280, 0)); // Position the player one image within the window

		// Create a text field to display the score of player two, initially set to "0"
		TextField playerTwoField = new TextField("0");
		playerTwoField.setStyle("-fx-background-color: linear-gradient(to right, #FFD700, #6B8E23); "
				+ "-fx-background-radius: 10; " + "-fx-border-width: 2; " + "-fx-border-radius: 10; "
				+ "-fx-font-weight: bold; " + "-fx-text-fill: white; " + "-fx-font-size: 15px; "
				+ "-fx-alignment: center;" + "-fx-padding: 5;");
		playerTwoField.setEditable(false); // Make the field non-editable
		playerTwoField.setPrefWidth(50); // Set preferred width of the field
		playerTwoField.setPrefHeight(35); // Set preferred height of the field

		// Create and display an image of player two
		Image imagePlayer2 = new Image("file:player2.jpg");
		ImageView imageViewPlaer2 = new ImageView(imagePlayer2);
		imageViewPlaer2.setFitWidth(200); // Set width of the player image
		imageViewPlaer2.setFitHeight(200); // Set height of the player image
		HBox imageboxPlayer2 = new HBox(imageViewPlaer2); // Wrap the image in a horizontal box (HBox)
		imageboxPlayer2.setPadding(new Insets(480, 0, 280, 390)); // Position the player two image within the window

		// Create properties to store the sum of coins collected by each player
		IntegerProperty sumPlayerOne = new SimpleIntegerProperty(0);
		IntegerProperty sumPlayerTwo = new SimpleIntegerProperty(0);

		// Create properties to store the current index of coin selection
		IntegerProperty startIndex = new SimpleIntegerProperty(0);
		IntegerProperty endIndex = new SimpleIntegerProperty(coinButtons.size() - 1);

		// Boolean property to determine whose turn it is (player one or player two)
		BooleanProperty isPlayerOneTurn = new SimpleBooleanProperty(true);

		// LinkedLists to track which coins each player has collected
		LinkedList<Integer> playerOneCoins = new LinkedList<>();
		LinkedList<Integer> playerTwoCoins = new LinkedList<>();

		// Create a 'Start' button to initiate the game
		Button startButton = new Button("Start");
		startButton.setStyle(
				"-fx-font-size: 20px;-fx-background-color: none;-fx-cursor: hand;-fx-font-weight: bold; -fx-text-fill: #FFD700;"
		// Style the 'Start' button with a gold color and cursor effect
		);

		startButton.setDisable(false); // Enable the 'Start' button
		startButton.setOnAction(e -> { // Set an event handler for when the button is clicked
			// Create radio buttons for player one and player two, using their names from
			// text fields
			RadioButton playerOneRadio = new RadioButton(playerOneTextField.getText());
			RadioButton playerTwoRadio = new RadioButton(playerTwoTextField.getText());

			// Create a ToggleGroup to allow only one player to be selected at a time
			ToggleGroup startGroup = new ToggleGroup();
			playerOneRadio.setToggleGroup(startGroup); // Add player one to the group
			playerTwoRadio.setToggleGroup(startGroup); // Add player two to the group

			// Style the radio buttons for both players to match the theme
			playerTwoRadio.setStyle("-fx-text-fill: white;-fx-mark-color: #FFD700;");
			playerOneRadio.setStyle("-fx-text-fill: white;-fx-mark-color: #FFD700;");

			// Set player one as the default selected player
			playerOneRadio.setSelected(true);

			// Create a confirmation alert to ask the user to choose who will start the game
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

			// Style the alert window and its buttons to match the game theme
			alert.getDialogPane().setStyle(
					"-fx-background-color: #6B8E23;-fx-border-color: none;-fx-font-size: 15px;-fx-font-family: Arial;");
			alert.getDialogPane().lookupButton(ButtonType.OK).setStyle(
					"-fx-background-color: #808000;-fx-border-color: none;-fx-cursor: hand; -fx-text-fill: white; ");
			alert.getDialogPane().lookupButton(ButtonType.CANCEL).setStyle(
					"-fx-background-color: #808000;-fx-border-color: none;-fx-cursor: hand; -fx-text-fill: white; ");

			// Set the size and appearance of the alert
			alert.getDialogPane().setPrefSize(400, 50);
			alert.setHeaderText(null); // No header
			alert.setGraphic(null); // No graphic icon
			alert.setTitle("Choose Player"); // Set the title of the alert window

			// Create a label to display the prompt for selecting a starting player
			Label titleAlert = new Label("Select the player who will start the game:");
			titleAlert.setStyle("-fx-text-fill: white;");

			// Create a VBox layout to arrange the label and radio buttons vertically
			VBox dialogPaneContent = new VBox(10, titleAlert, playerOneRadio, playerTwoRadio);
			alert.getDialogPane().setContent(dialogPaneContent); // Set the content of the alert

			// Display the alert and wait for the user's response
			alert.showAndWait().ifPresent(response -> {
				// Set the player's turn based on the user's selection
				isPlayerOneTurn.set(playerOneRadio.isSelected());

				// Enable the coin buttons for the starting player
				coinButtons.get(startIndex.get()).setDisable(false);
				coinButtons.get(endIndex.get()).setDisable(false);
			});

			// Disable the 'Start' button after the selection is made
			startButton.setDisable(true);
		});
		// Define the event handler for when a coin button is clicked
		EventHandler<ActionEvent> coinButtonHandler = event -> {
			// Get the clicked button and retrieve the coin value
			Button clickedButton = (Button) event.getSource();
			int coinValue = Integer.parseInt(clickedButton.getText());

			// Check if it's player one's turn
			if (isPlayerOneTurn.get()) {
				// Add the coin value to player one's total
				sumPlayerOne.set(sumPlayerOne.get() + coinValue);
				playerOneField.setText(String.valueOf(sumPlayerOne.get())); // Update the score display
				playerOneCoins.add(coinValue); // Add the coin to player one's list
				// Change the button's style for player one's turn (red text)
				clickedButton.setStyle(
						"-fx-font-size:18px;-fx-cursor: hand;-fx-text-fill: red; -fx-font-weight: bold; -fx-background-color:none ;");
			} else {
				// Add the coin value to player two's total
				sumPlayerTwo.set(sumPlayerTwo.get() + coinValue);
				playerTwoField.setText(String.valueOf(sumPlayerTwo.get())); // Update the score display
				playerTwoCoins.add(coinValue); // Add the coin to player two's list
				// Change the button's style for player two's turn (blue text)
				clickedButton.setStyle(
						"-fx-font-size:18px;-fx-cursor: hand;-fx-text-fill: blue; -fx-font-weight: bold; -fx-background-color:none ;");
			}

			// Disable the clicked button to prevent re-selection
			clickedButton.setDisable(true);

			// Update the starting index if the clicked button was the starting coin
			if (clickedButton == coinButtons.get(startIndex.get())) {
				startIndex.set(startIndex.get() + 1);
			}
			// Update the ending index if the clicked button was the ending coin
			else if (clickedButton == coinButtons.get(endIndex.get())) {
				endIndex.set(endIndex.get() - 1);
			}

			// Enable the next available coin buttons if there are any left to pick
			if (startIndex.get() <= endIndex.get()) {
				coinButtons.get(startIndex.get()).setDisable(false);
				coinButtons.get(endIndex.get()).setDisable(false);
			}

			// Toggle the turn between player one and player two
			isPlayerOneTurn.set(!isPlayerOneTurn.get());

			// Check if all the coins have been selected
			if (startIndex.get() > endIndex.get()) {
				// Determine the winner based on the total scores
				String winnerMessage;
				if (sumPlayerOne.get() > sumPlayerTwo.get()) {
					winnerMessage = "Congratulations!!!!\n\n" + playerOneTextField.getText() + " wins with "
							+ sumPlayerOne.get() + " points!";
				} else if (sumPlayerTwo.get() > sumPlayerOne.get()) {
					winnerMessage = "Congratulations!!!!\n\n" + playerTwoTextField.getText() + " wins with "
							+ sumPlayerTwo.get() + " points!";
				} else {
					winnerMessage = "Congratulations!!!!\n\n" + "It's a tie!";
				}

				// Show the winner message with an animated gif
				showAlertWithImage(winnerMessage, "file:win.gif");

				// Enable the result button to show the final result
				resultButton.setDisable(false);
			}
		};

		// Assign the event handler to each coin button
		for (int i = 0; i < coinButtons.size(); i++) {
			coinButtons.get(i).setOnAction(coinButtonHandler); // Set the event handler for each button
		}

		// Set up the style for the resultButton with a gradient background and text
		// formatting
		resultButton.setStyle("-fx-font-size: 20px; " + "-fx-background-color: linear-gradient(#FFD700,#6B8E23); "
				+ "-fx-font-weight: bold; " + "-fx-text-fill: #FFD700; " + "-fx-cursor: hand; "
				+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;");

		// Event handler for mouse enter: changes the button's style when the mouse
		// hovers over it
		resultButton.setOnMouseEntered(c -> resultButton
				.setStyle("-fx-font-size: 22px; " + "-fx-background-color: linear-gradient(#6B8E23,#FFD700); "
						+ "-fx-font-weight: bold; " + "-fx-text-fill: #6B8E23; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;"));

		// Event handler for mouse exit: resets the button's style when the mouse leaves
		resultButton.setOnMouseExited(c -> resultButton
				.setStyle("-fx-font-size: 20px; " + "-fx-background-color: linear-gradient(#FFD700,#6B8E23); "
						+ "-fx-font-weight: bold; " + "-fx-text-fill: #FFD700; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;"));

		// Event handler for the button click: opens a new window to display the game
		// results
		resultButton.setOnAction(e -> {
			Stage resultStage = new Stage(); // Create a new stage for displaying results
			resultStage.setTitle("Game Results"); // Set the title for the results window

			// Create a "Back" button that allows users to close the result window
			Button back = new Button("Back");
			back.setStyle("-fx-font-size: 20px; " + "-fx-background-color: linear-gradient(#FFD700,#6B8E23); "
					+ "-fx-font-weight: bold; " + "-fx-text-fill: #FFD700; " + "-fx-cursor: hand; "
					+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;");

			// Change the style of the "Back" button when the mouse enters and exits
			back.setOnMouseEntered(c -> back
					.setStyle("-fx-font-size: 22px; " + "-fx-background-color: linear-gradient(#6B8E23,#FFD700); "
							+ "-fx-font-weight: bold; " + "-fx-text-fill: #6B8E23; " + "-fx-cursor: hand; "
							+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;"));

			back.setOnMouseExited(c -> back
					.setStyle("-fx-font-size: 20px; " + "-fx-background-color: linear-gradient(#FFD700,#6B8E23); "
							+ "-fx-font-weight: bold; " + "-fx-text-fill: #FFD700; " + "-fx-cursor: hand; "
							+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;"));

			// Align the back button at the bottom center of the pane
			back.setAlignment(Pos.BOTTOM_CENTER);

			// Event handler for the "Back" button click: closes the result window
			back.setOnAction(x -> {
				resultStage.close(); // Close the result window
			});

			// Create and style an image for the title of the result stage
			Image title1 = new Image("file:title.png");
			ImageView titleView1 = new ImageView(title1);
			titleView1.setFitWidth(250);
			titleView1.setFitHeight(100);
			HBox box0 = new HBox(titleView1);
			box0.setPadding(new Insets(5, 0, 0, 0));
			box0.setAlignment(Pos.TOP_CENTER);

			// Create a stack pane to hold the content of the result window
			Pane pane = new StackPane();
			pane.setStyle("-fx-background-color: #6B8E23;");

			// Create and style the VBox for displaying Player 1's information
			VBox playerOne = new VBox(10, new Label("Player 1: "), new Label("Name: " + playerOneTextField.getText()),
					new Label("Coins Chosen: \n" + playerOneCoins.toString()),
					new Label("Total: " + sumPlayerOne.get()));
			playerOne.setAlignment(Pos.CENTER_LEFT);
			playerOne.setStyle(
					"-fx-font-size: 15px;-fx-border-color: #DAA520; -fx-border-width: 1.5px; -fx-border-radius: 5px; -fx-padding: 10px;-fx-text-fill: white;");

			// Create and style the VBox for displaying Player 2's information
			VBox playerTwo = new VBox(10, new Label("Player 2: "), new Label("Name: " + playerTwoTextField.getText()),
					new Label("Coins Chosen: \n" + playerTwoCoins.toString()),
					new Label("Total: " + sumPlayerTwo.get()));
			playerTwo.setAlignment(Pos.CENTER_LEFT);
			playerTwo.setStyle(
					"-fx-font-size: 15px;-fx-border-color: #DAA520; -fx-border-width: 1.5px; -fx-border-radius: 5px; -fx-padding: 10px;-fx-text-fill: white;");

			// Create a horizontal box to display Player 1 and Player 2 information side by
			// side
			HBox playerBox = new HBox(30, playerOne, playerTwo);
			playerBox.setPadding(new Insets(90, 0, 0, 0));
			playerBox.setAlignment(Pos.CENTER);

			// Create a vertical box to hold the player information and back button
			VBox box = new VBox(50, playerBox, back);
			box.setPadding(new Insets(20));
			box.setAlignment(Pos.CENTER);

			// Add all the elements to the main pane
			pane.getChildren().addAll(box0, box);

			// Create and set the scene for the result window
			Scene resultScene = new Scene(pane, 570, 440);
			resultStage.setScene(resultScene);
			resultStage.show(); // Show the result window
		});

		// Create a "Restart" button with a styled appearance
		Button restartButton = new Button("Restart");
		restartButton.setStyle("-fx-font-size: 20px; " + "-fx-background-color: linear-gradient(#FFD700,#6B8E23); "
				+ "-fx-font-weight: bold; " + "-fx-text-fill: #FFD700; " + "-fx-cursor: hand; "
				+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;");

		// Event handler for mouse entering the button: changes the button style when
		// hovered over
		restartButton.setOnMouseEntered(c -> restartButton
				.setStyle("-fx-font-size: 22px; " + "-fx-background-color: linear-gradient(#6B8E23,#FFD700); "
						+ "-fx-font-weight: bold; " + "-fx-text-fill: #6B8E23; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;"));

		// Event handler for mouse exiting the button: resets the button style when the
		// mouse leaves
		restartButton.setOnMouseExited(c -> restartButton
				.setStyle("-fx-font-size: 20px; " + "-fx-background-color: linear-gradient(#FFD700,#6B8E23); "
						+ "-fx-font-weight: bold; " + "-fx-text-fill: #FFD700; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;"));

		// Event handler for the restart button click: closes the current game window
		// and returns to the home screen
		restartButton.setOnAction(e -> {
			// Close the current stage and open the home scene when the button is clicked
						Image gifImage = new Image("file:load.gif");
						ImageView gifView = new ImageView(gifImage);

						gifView.setFitWidth(800);
						gifView.setFitHeight(800);
						gifView.setPreserveRatio(true);

						StackPane splashPane = new StackPane(gifView);
						Scene splashScene = new Scene(splashPane, 570, 440);

						twoPlayerScane2.setScene(splashScene);
						twoPlayerScane2.setTitle("Loading...");
						twoPlayerScane2.show();

						PauseTransition delay = new PauseTransition(Duration.seconds(1));
						delay.setOnFinished(event -> {
							twoPlayerScane2.close();
							homeScane();
						});

						delay.play();

		});

		// Create a horizontal box to hold the restart and result buttons
		HBox buttonsBox = new HBox(20, restartButton, resultButton);
		buttonsBox.setAlignment(Pos.BOTTOM_CENTER); // Align the buttons at the bottom center

		// Create and style a label to display Player 1's name
		Label player1Name = new Label(playerOneTextField.getText());
		player1Name.setStyle("-fx-alignment: center;-fx-font-size: 15px;-fx-text-fill: #FFD700;");

		// Create a vertical box to display Player 1's field and name
		VBox player1 = new VBox(10, playerOneField, player1Name);
		player1.setAlignment(Pos.CENTER); // Align Player 1's information at the center

		// Create and style a label to display Player 2's name
		Label player2Name = new Label(playerTwoTextField.getText());
		player2Name.setStyle("-fx-alignment: center;-fx-font-size: 15px;-fx-text-fill: #FFD700;");

		// Create a vertical box to display Player 2's field and name
		VBox player2 = new VBox(10, playerTwoField, player2Name);
		player2.setAlignment(Pos.CENTER); // Align Player 2's information at the center

		// Create a horizontal box to hold Player 1, start button, and Player 2's
		// information side by side
		HBox box0 = new HBox(20, player1, startButton, player2);
		box0.setAlignment(Pos.CENTER); // Align the items at the center

		// Create the main layout of the scene, combining all the components
		VBox box = new VBox(35, coinsPane, box0, buttonsBox);
		box.setAlignment(Pos.CENTER); // Align all elements in the center
		box.setPadding(new Insets(70, 20, 0, 20)); // Add padding around the main content

		// Add all the components to the main pane
		mainPain.getChildren().addAll(titlebox, imageboxPlayer1, imageboxPlayer2, box);

		// Create the scene with the main pane, setting its size and making the window
		// non-resizable
		Scene scene = new Scene(mainPain, 570, 440);
		twoPlayerScane2.setResizable(false); // Disable window resizing

		// Set the scene for the two-player game window and show it
		twoPlayerScane2.setScene(scene);
		twoPlayerScane2.show();
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void OnePlayerScane() {
		// Create a new Stage (window) for the One Player game scene
		Stage OnePlayerScane = new Stage();
		OnePlayerScane.setTitle("Coins Game"); // Set the title of the game window

		// Load and display the title image at the top of the window
		Image title = new Image("file:title.png");
		ImageView titleView = new ImageView(title);
		titleView.setFitWidth(250); // Set the width of the title image
		titleView.setFitHeight(100); // Set the height of the title image
		HBox titlebox = new HBox(titleView); // Place the title image in a horizontal box
		titlebox.setPadding(new Insets(5, 0, 0, 0)); // Add padding to the title box
		titlebox.setAlignment(Pos.TOP_CENTER); // Align the title at the top center of the window

		// Create the main pane for the scene and set the background color
		Pane mainPain = new StackPane();
		mainPain.setStyle("-fx-background-color: #6B8E23;"); // Set the background color to green

		// Create the "Show Result" button and disable it initially
		Button resultButton = new Button("Show Result");
		resultButton.setDisable(true); // Disable the button initially

		// Create the "Details" button and disable it initially
		Button detailsButton = new Button("Details");
		detailsButton.setDisable(true); // Disable the button initially

		// Create a label to display the optimal result and calculate the optimal sum of
		// coins
		Label optimalResult = new Label("");
		optimalResult.setStyle("-fx-text-fill: #FFD700; -fx-font-weight: bold;");
		int optimalSum = calculateOptimalResult(CoinsList); // Calculate the optimal sum using the list of coin values
		optimalResult.setText("Optimal Result: " + optimalSum); // Set the label text to show the optimal result

		// Create a FlowPane to arrange the coin buttons with horizontal and vertical
		// gaps
		FlowPane coinsPane = new FlowPane();
		coinsPane.setHgap(10); // Set horizontal gap between buttons
		coinsPane.setVgap(10); // Set vertical gap between buttons
		coinsPane.setAlignment(Pos.CENTER); // Align the coin buttons at the center

		// Create and style buttons for each coin in the CoinsList
		LinkedList<Button> coinButtons = new LinkedList<>();
		for (Integer coinValue : CoinsList) {
			Button coinButton = new Button(coinValue.toString()); // Create a button for each coin value
			coinButton.setStyle(
					"-fx-font-size:20px;-fx-cursor: hand;-fx-font-weight: bold; -fx-text-fill: #FFD700; -fx-background-color:none ;");
			coinButton.setDisable(true); // Disable the coin button initially
			coinButtons.add(coinButton); // Add the button to the list of coin buttons
			coinsPane.getChildren().add(coinButton); // Add the coin button to the coinsPane
		}

		// Create a TextField to display the sum for Computer 1 and style it
		TextField computer1Field = new TextField("0");
		computer1Field.setEditable(false); // Disable editing of the text field
		computer1Field.setStyle("-fx-background-color: linear-gradient(to right, #FFD700, #6B8E23); "
				+ "-fx-background-radius: 10; " + "-fx-border-width: 2; " + "-fx-border-radius: 10; "
				+ "-fx-font-weight: bold; " + "-fx-text-fill: white; " + "-fx-font-size: 15px; "
				+ "-fx-alignment: center;" + "-fx-padding: 5;");
		computer1Field.setPrefWidth(50); // Set preferred width of the text field
		computer1Field.setPrefHeight(35); // Set preferred height of the text field

		// Create an image for Computer 1 and place it in a horizontal box (HBox)
		Image imagecomputer1 = new Image("file:computer1.png");
		ImageView imageViewcomputer1 = new ImageView(imagecomputer1);
		imageViewcomputer1.setFitWidth(170); // Set width of the image
		imageViewcomputer1.setFitHeight(170); // Set height of the image
		HBox imageboxcomputer1 = new HBox(imageViewcomputer1);
		imageboxcomputer1.setPadding(new Insets(400, 390, 250, 0)); // Add padding to position the image

		// Create a TextField to display the sum for Computer 2 and style it
		TextField computer2Field = new TextField("0");
		computer2Field.setStyle("-fx-background-color: linear-gradient(to right, #FFD700, #6B8E23); "
				+ "-fx-background-radius: 10; " + "-fx-border-width: 2; " + "-fx-border-radius: 10; "
				+ "-fx-font-weight: bold; " + "-fx-text-fill: white; " + "-fx-font-size: 15px; "
				+ "-fx-alignment: center;" + "-fx-padding: 5;");
		computer2Field.setEditable(false); // Disable editing of the text field
		computer2Field.setPrefWidth(50); // Set preferred width of the text field
		computer2Field.setPrefHeight(35); // Set preferred height of the text field

		// Create an image for Computer 2 and place it in a horizontal box (HBox)
		Image imagecomputer2 = new Image("file:computer2.jpg");
		ImageView imageViewcomputer2 = new ImageView(imagecomputer2);
		imageViewcomputer2.setFitWidth(170); // Set width of the image
		imageViewcomputer2.setFitHeight(170); // Set height of the image
		HBox imageboxcomputer2 = new HBox(imageViewcomputer2);
		imageboxcomputer2.setPadding(new Insets(420, 0, 280, 390)); // Add padding to position the image

		// IntegerProperties to keep track of the sum of coins for Computer 1 and
		// Computer 2
		IntegerProperty sumComputer1 = new SimpleIntegerProperty(0);
		IntegerProperty sumComputer2 = new SimpleIntegerProperty(0);

		// IntegerProperties to keep track of the current index range for selecting coin
		// buttons
		IntegerProperty startIndex = new SimpleIntegerProperty(0);
		IntegerProperty endIndex = new SimpleIntegerProperty(coinButtons.size() - 1);

		// BooleanProperty to track whose turn it is (Computer 1 or Computer 2)
		BooleanProperty isComputer1Turn = new SimpleBooleanProperty(true);

		// LinkedLists to store the coins selected by each computer
		LinkedList<Integer> Computer1Coins = new LinkedList<>();
		LinkedList<Integer> Computer2Coins = new LinkedList<>();

		// Create a Start button and set its initial style
		Button startButton = new Button("Start");
		startButton.setDisable(false); // Initially, the button is enabled
		startButton.setStyle(
				"-fx-font-size: 20px;-fx-background-color: none;-fx-cursor: hand;-fx-font-weight: bold; -fx-text-fill: #FFD700;"); // Style
																																	// the
																																	// button

		// Set the action to be performed when the Start button is clicked
		startButton.setOnAction(e -> {
			// Start the game
			isComputer1Turn.set(true); // Set that it's Computer 1's turn to start
			startButton.setDisable(true); // Disable the start button after the game begins

			// Initialize the dynamic programming table for optimal play
			int[][] dp = calculateOptimalDPTable(CoinsList); // Calculate optimal DP table based on the coins list

			// Create a Timeline to simulate turns and actions during the game
			Timeline timeline = new Timeline();
			timeline.setCycleCount(Timeline.INDEFINITE); // Run indefinitely until manually stopped

			// Define a KeyFrame for updating the game state every second
			KeyFrame keyFrame = new KeyFrame(Duration.seconds(1.0), event -> {
				int start = startIndex.get(); // Get the current start index for coin selection
				int end = endIndex.get(); // Get the current end index for coin selection

				// Validate indices to ensure they are within the valid range
				if (start < 0 || end < 0 || start >= CoinsList.size() || end >= CoinsList.size() || start > end) {
					timeline.stop(); // Stop the game if the indices are invalid
					// showWinner(sumComputer1, sumComputer2, resultButton, detailsButton); //
					// (Uncomment to show the winner)
					return;
				}

				int firstCoin = CoinsList.get(start); // Get the value of the first coin
				int lastCoin = CoinsList.get(end); // Get the value of the last coin

				// Game logic for Computer 1's turn
				if (isComputer1Turn.get()) {
					// If picking the first coin results in a better score, choose it
					if (dp[start + 1][end] <= dp[start][end - 1]) {
						sumComputer1.set(sumComputer1.get() + firstCoin); // Add the value of the coin to Computer 1's
																			// score
						Computer1Coins.add(firstCoin); // Add the coin to Computer 1's list of selected coins
						coinButtons.get(start).setStyle(
								"-fx-font-size:18px;-fx-cursor: hand;-fx-text-fill: blue; -fx-font-weight: bold; -fx-background-color:none;");
						startIndex.set(start + 1); // Update the start index to the next coin
					} else {
						sumComputer1.set(sumComputer1.get() + lastCoin); // Add the value of the last coin to Computer
																			// 1's score
						Computer1Coins.add(lastCoin); // Add the coin to Computer 1's list of selected coins
						coinButtons.get(end).setStyle(
								"-fx-font-size:18px;-fx-cursor: hand;-fx-text-fill: blue; -fx-font-weight: bold; -fx-background-color:none;");
						endIndex.set(end - 1); // Update the end index to the previous coin
					}
				} else {
					// Game logic for Computer 2's turn
					// If picking the first coin results in a better score, choose it
					if (dp[start][end] <= dp[start][end - 1] ) {
						sumComputer2.set(sumComputer2.get() + firstCoin); // Add the value of the coin to Computer 2's
																			// score
						Computer2Coins.add(firstCoin); // Add the coin to Computer 2's list of selected coins
						coinButtons.get(start).setStyle(
								"-fx-font-size:18px;-fx-cursor: hand;-fx-text-fill: red; -fx-font-weight: bold; -fx-background-color:none;");
						startIndex.set(start + 1); // Update the start index to the next coin
					} else {
						sumComputer2.set(sumComputer2.get() + lastCoin); // Add the value of the last coin to Computer
																			// 2's score
						Computer2Coins.add(lastCoin); // Add the coin to Computer 2's list of selected coins
						coinButtons.get(end).setStyle(
								"-fx-font-size:18px;-fx-cursor: hand;-fx-text-fill: red; -fx-font-weight: bold; -fx-background-color:none;");
						endIndex.set(end - 1); // Update the end index to the previous coin
					}
				}

				// Update the score display for both computer players
				if (isComputer1Turn.get()) {
					computer1Field.setText(String.valueOf(sumComputer1.get())); // Update Computer 1's score
				} else {
					computer2Field.setText(String.valueOf(sumComputer2.get())); // Update Computer 2's score
				}

				// Switch turns between Computer 1 and Computer 2
				isComputer1Turn.set(!isComputer1Turn.get());

				// Check if all coins have been selected
				if (startIndex.get() > endIndex.get()) {
					String winnerMessage; // Variable to hold the winner message
					// Determine the winner based on the scores
					if (sumComputer1.get() > sumComputer2.get()) {
						winnerMessage = "Congratulations!!!!\n\n Computer1 wins with " + sumComputer1.get()
								+ " points!";
					} else if (sumComputer2.get() > sumComputer1.get()) {
						winnerMessage = "Congratulations!!!!\n\n Computer2 wins with " + sumComputer2.get()
								+ " points!";
					} else {
						winnerMessage = "Congratulations!!!!\n\nIt's a tie!"; // If scores are equal, it's a tie
					}

					// Display the winner message and animation
					Platform.runLater(() -> showAlertWithImage(winnerMessage, "file:win.gif"));

					// Enable the result and details buttons once the game ends
					resultButton.setDisable(false);
					detailsButton.setDisable(false);

					timeline.stop(); // Stop the game timeline once the game ends
				}
			});

			// Add the keyframe to the timeline and start the game
			timeline.getKeyFrames().add(keyFrame);
			timeline.play(); // Begin the timeline animation (game logic)
		});
		// Style the details button and set its initial style
		detailsButton.setStyle("-fx-font-size: 20px; " + "-fx-background-color: linear-gradient(#FFD700,#6B8E23); "
				+ "-fx-font-weight: bold; " + "-fx-text-fill: #FFD700; " + "-fx-cursor: hand; "
				+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;");

		// Event handler for when the mouse enters the details button
		detailsButton.setOnMouseEntered(e -> detailsButton
				.setStyle("-fx-font-size: 22px; " + "-fx-background-color: linear-gradient(#6B8E23,#FFD700); "
						+ "-fx-font-weight: bold; " + "-fx-text-fill: #6B8E23; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;"));

		// Event handler for when the mouse exits the details button
		detailsButton.setOnMouseExited(e -> detailsButton
				.setStyle("-fx-font-size: 20px; " + "-fx-background-color: linear-gradient(#FFD700,#6B8E23); "
						+ "-fx-font-weight: bold; " + "-fx-text-fill: #FFD700; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;"));

		// Event handler for when the details button is clicked
		detailsButton.setOnAction(e -> {
			// Create a new Stage (popup window) for displaying game results
			Stage detailsStage = new Stage();
			detailsStage.setTitle("Game Results");

			// Create and style a Back button to close the details window
			Button back = new Button("Back");
			back.setStyle("-fx-font-size: 16px; " + "-fx-background-color: linear-gradient(#FFD700,#6B8E23); "
					+ "-fx-font-weight: bold; " + "-fx-text-fill: #FFD700; " + "-fx-cursor: hand; "
					+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;");

			// Event handlers to change the style of the Back button when the mouse enters
			// or exits
			back.setOnMouseEntered(c -> back
					.setStyle("-fx-font-size: 18px; " + "-fx-background-color: linear-gradient(#6B8E23,#FFD700); "
							+ "-fx-font-weight: bold; " + "-fx-text-fill: #6B8E23; " + "-fx-cursor: hand; "
							+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;"));
			back.setOnMouseExited(c -> back
					.setStyle("-fx-font-size: 16px; " + "-fx-background-color: linear-gradient(#FFD700,#6B8E23); "
							+ "-fx-font-weight: bold; " + "-fx-text-fill: #FFD700; " + "-fx-cursor: hand; "
							+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;"));

			// Create a horizontal box to hold the Back button
			HBox box = new HBox(back);

			// Event handler to close the details stage when the Back button is clicked
			back.setOnAction(x -> {
				detailsStage.close(); // Close the details window
			});

			// Set the alignment of the back button at the bottom center of the screen
			box.setAlignment(Pos.BOTTOM_CENTER);

			// Create the main pane for the details window
			Pane pane = new StackPane();
			pane.setStyle("-fx-background-color: #6B8E23;");

			// Calculate the optimal DP table for the game
			int[][] dp = calculateOptimalDPTable(CoinsList);

			// Create a GridPane to display the DP table
			GridPane gridPane = createDPGridPane(CoinsList, dp);
			gridPane.setAlignment(Pos.CENTER);

			// Create a VBox to hold the elements (title, DP table, and back button)
			VBox ele = new VBox(5, gridPane, back);
			ele.setAlignment(Pos.CENTER);
			ele.setPadding(new Insets(10, 0, 0, 0));
			// Add the VBox to the main pane
			pane.getChildren().add(ele);

			// Create the scene for the details window
			Scene detailsScene = new Scene(pane, 570, 440);
			detailsStage.setScene(detailsScene); // Set the scene to the stage
			detailsStage.show(); // Display the details stage
		});
		// Initial style for the result button when it is first displayed
		resultButton.setStyle("-fx-font-size: 20px; " + "-fx-background-color: linear-gradient(#FFD700,#6B8E23); "
				+ "-fx-font-weight: bold; " + "-fx-text-fill: #FFD700; " + "-fx-cursor: hand; "
				+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;");

		// Event handler for when the mouse enters the result button: Changes the button
		// style on hover
		resultButton.setOnMouseEntered(e -> resultButton
				.setStyle("-fx-font-size: 22px; " + "-fx-background-color: linear-gradient(#6B8E23,#FFD700); "
						+ "-fx-font-weight: bold; " + "-fx-text-fill: #6B8E23; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;"));

		// Event handler for when the mouse exits the result button: Resets the button
		// style when the hover ends
		resultButton.setOnMouseExited(e -> resultButton
				.setStyle("-fx-font-size: 20px; " + "-fx-background-color: linear-gradient(#FFD700,#6B8E23); "
						+ "-fx-font-weight: bold; " + "-fx-text-fill: #FFD700; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;"));

		// Event handler for when the result button is clicked: Opens a new stage
		// showing the game results
		resultButton.setOnAction(e -> {
			// Create a new stage (popup window) for displaying the results
			Stage resultStage = new Stage();
			resultStage.setTitle("Game Results"); // Set the title for the results window

			// Create a 'Back' button and style it
			Button back = new Button("Back");
			back.setStyle("-fx-font-size: 20px; " + "-fx-background-color: linear-gradient(#FFD700,#6B8E23); "
					+ "-fx-font-weight: bold; " + "-fx-text-fill: #FFD700; " + "-fx-cursor: hand; "
					+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;");

			// Event handler for when the mouse enters the 'Back' button: Changes the style
			// of the button
			back.setOnMouseEntered(c -> back
					.setStyle("-fx-font-size: 22px; " + "-fx-background-color: linear-gradient(#6B8E23,#FFD700); "
							+ "-fx-font-weight: bold; " + "-fx-text-fill: #6B8E23; " + "-fx-cursor: hand; "
							+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;"));

			// Event handler for when the mouse exits the 'Back' button: Resets the style of
			// the button
			back.setOnMouseExited(c -> back
					.setStyle("-fx-font-size: 20px; " + "-fx-background-color: linear-gradient(#FFD700,#6B8E23); "
							+ "-fx-font-weight: bold; " + "-fx-text-fill: #FFD700; " + "-fx-cursor: hand; "
							+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;"));

			// Align the Back button to the bottom center of the result window
			back.setAlignment(Pos.BOTTOM_CENTER);

			// Event handler for the Back button: Closes the result window when clicked
			back.setOnAction(x -> {
				resultStage.close(); // Close the result stage (popup window)
			});

			// Set padding for the Back button to position it properly
			back.setPadding(new Insets(0, 0, 10, 0));

			// Add an image as the title of the result window
			Image title1 = new Image("file:title.png"); // Load the title image from a file
			ImageView titleView1 = new ImageView(title1); // Create an ImageView for displaying the image
			titleView1.setFitWidth(250); // Set the width of the image
			titleView1.setFitHeight(100); // Set the height of the image

			// Create a HBox to hold the title image and align it at the top center of the
			// window
			HBox box0 = new HBox(titleView1);
			box0.setPadding(new Insets(5, 0, 0, 0)); // Add padding to the top of the title image
			box0.setAlignment(Pos.TOP_CENTER);

			// Create the main pane for the result window with a green background
			Pane pane = new StackPane();
			pane.setStyle("-fx-background-color: #6B8E23;");

			// Display player 1 (Computer 1) results in a VBox
			VBox playerOne = new VBox(10, new Label("Computer 1: "),
					new Label("Coins Chosen: \n" + Computer1Coins.toString()), // Display coins chosen by player 1
					new Label("Total: " + sumComputer1.get())); // Display total score of player 1
			playerOne.setAlignment(Pos.CENTER_LEFT); // Align player 1's details to the left
			playerOne.setStyle(
					"-fx-font-size: 15px;-fx-border-color: #DAA520; -fx-border-width: 1.5px; -fx-border-radius: 5px; -fx-padding: 10px;-fx-text-fill: white;");

			// Display player 2 (Computer 2) results in a VBox
			VBox playerTwo = new VBox(10, new Label("Computer 2: "),
					new Label("Coins Chosen: \n" + Computer2Coins.toString()), // Display coins chosen by player 2
					new Label("Total: " + sumComputer2.get())); // Display total score of player 2
			playerTwo.setAlignment(Pos.CENTER_LEFT); // Align player 2's details to the left
			playerTwo.setStyle(
					"-fx-font-size: 15px;-fx-border-color: #DAA520; -fx-border-width: 1.5px; -fx-border-radius: 5px; -fx-padding: 10px;-fx-text-fill: white;");

			// Create a HBox to display the results of both players side by side
			HBox playerBox = new HBox(30, playerOne, playerTwo);
			playerBox.setPadding(new Insets(90, 0, 0, 0)); // Add padding to the top of the player results
			playerBox.setAlignment(Pos.CENTER); // Center align the player results horizontally

			// Create a VBox to hold both the player results and the Back button
			VBox box = new VBox(50, playerBox, back);
			box.setPadding(new Insets(20)); // Add padding around the box
			box.setAlignment(Pos.CENTER); // Center align the content in the VBox

			// Add all the components (title, player results, and Back button) to the main
			// pane
			pane.getChildren().addAll(box0, box);

			// Create the scene for the result window
			Scene resultScene = new Scene(pane, 570, 440);
			resultStage.setScene(resultScene); // Set the scene to the stage
			resultStage.show(); // Show the result window
		});

		// Create the 'Restart' button and set its initial style
		Button restartButton = new Button("Restart");
		restartButton.setStyle("-fx-font-size: 20px; " + "-fx-background-color: linear-gradient(#FFD700,#6B8E23); "
				+ "-fx-font-weight: bold; " + "-fx-text-fill: #FFD700; " + "-fx-cursor: hand; "
				+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;");

		// Event handler for mouse entering the restart button: Changes its style
		restartButton.setOnMouseEntered(e -> restartButton
				.setStyle("-fx-font-size: 22px; " + "-fx-background-color: linear-gradient(#6B8E23,#FFD700); "
						+ "-fx-font-weight: bold; " + "-fx-text-fill: #6B8E23; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;"));

		// Event handler for mouse exiting the restart button: Resets its style
		restartButton.setOnMouseExited(e -> restartButton
				.setStyle("-fx-font-size: 20px; " + "-fx-background-color: linear-gradient(#FFD700,#6B8E23); "
						+ "-fx-font-weight: bold; " + "-fx-text-fill: #FFD700; " + "-fx-cursor: hand; "
						+ "-fx-border-width: 2px; " + "-fx-padding: 2px 2px;" + "-fx-border-radius: 10px;"));

		// Event handler for clicking the 'Restart' button: Closes the current stage and
		// reloads the home scene
		restartButton.setOnAction(e -> {
			// Close the current stage and open the home scene when the button is clicked
			Image gifImage = new Image("file:load.gif");
			ImageView gifView = new ImageView(gifImage);

			gifView.setFitWidth(800);
			gifView.setFitHeight(800);
			gifView.setPreserveRatio(true);

			StackPane splashPane = new StackPane(gifView);
			Scene splashScene = new Scene(splashPane, 570, 440);

			OnePlayerScane.setScene(splashScene);
			OnePlayerScane.setTitle("Loading...");
			OnePlayerScane.show();

			PauseTransition delay = new PauseTransition(Duration.seconds(1));
			delay.setOnFinished(event -> {
				OnePlayerScane.close();
				homeScane();
			});

			delay.play();

		});

		// Create a box to hold the 'Restart', 'Results', and 'Details' buttons
		// horizontally
		HBox buttonsBox = new HBox(20, restartButton, resultButton, detailsButton);
		buttonsBox.setAlignment(Pos.BOTTOM_CENTER); // Align buttons at the bottom center of the screen

		// Create a label and field for 'computer1' and style the label
		Label comp1 = new Label("computer1");
		comp1.setStyle("-fx-text-fill: #FFD700");
		VBox computer1 = new VBox(10, computer1Field, comp1); // Stack the field and label vertically for computer 1
		computer1.setAlignment(Pos.CENTER); // Center align the content of the VBox

		// Create a label and field for 'computer2' and style the label
		Label comp2 = new Label("computer2");
		comp2.setStyle("-fx-text-fill: #FFD700");
		VBox computer2 = new VBox(10, computer2Field, comp2); // Stack the field and label vertically for computer 2
		computer2.setAlignment(Pos.CENTER); // Center align the content of the VBox

		// Create a box to hold the computer sections and the start button horizontally
		HBox compBox = new HBox(30, computer1, startButton, computer2);
		compBox.setAlignment(Pos.CENTER); // Center align the content horizontally

		// Create the main content box that holds all elements like coins pane and
		// results
		VBox box = new VBox(20, coinsPane, compBox, optimalResult);
		VBox boxA = new VBox(60, box, buttonsBox); // Stack the main content box and the buttons box vertically

		// Align both the main box and the buttons box to the center
		box.setAlignment(Pos.CENTER);
		boxA.setAlignment(Pos.CENTER);

		// Add padding to the main content box to position elements nicely
		box.setPadding(new Insets(80, 20, 0, 20));

		// Add the elements (title, images, main box) to the main pane
		mainPain.getChildren().addAll(titlebox, imageboxcomputer1, imageboxcomputer2, boxA);

		// Create the scene with the main pane, set the size and make it non-resizable
		Scene scene = new Scene(mainPain, 570, 440);
		OnePlayerScane.setResizable(false); // Make the game window non-resizable

		// Set the scene to the OnePlayerScane stage and display it
		OnePlayerScane.setScene(scene);
		OnePlayerScane.show();
	}

	private int calculateOptimalResult(LinkedList<Integer> coins) {
	    int n = coins.size(); // Get the number of coins.
	    // Base case: if there are no coins, the result is 0.
	    if (n == 0) {
	        return 0;
	    }
	    // Create a 2D DP table to store the results of subproblems.
	    int[][] dp = new int[n][n];
	    // Iterate over all possible ranges in reverse order (i to j).
	    // Start from the last index and move towards the first.
	    for (int i = n - 1; i >= 0; i--) {
	        // For each start index `i`, calculate results for ranges ending at `j`.
	        for (int j = i; j < n; j++) {
	            if (i == j) {
	                // Base case: If the range contains only one coin, the result is the coin's value.
	                dp[i][j] = coins.get(i);
	            } else {
	                // Option 1: Pick the first coin in the range (coins.get(i)).
	                // - The opponent's optimal choice is considered next.
	                int pickFirst = coins.get(i) + Math.min(
	                    (i + 2 <= j ? dp[i + 2][j] : 0),       // Case when opponent picks the second coin.
	                    (i + 1 <= j - 1 ? dp[i + 1][j - 1] : 0) // Case when opponent picks the last coin.
	                );

	                // Option 2: Pick the last coin in the range (coins.get(j)).
	                // - Again, the opponent's optimal choice is considered next.
	                int pickLast = coins.get(j) + Math.min(
	                    (i + 1 <= j - 1 ? dp[i + 1][j - 1] : 0), // Case when opponent picks the first coin.
	                    (i <= j - 2 ? dp[i][j - 2] : 0)          // Case when opponent picks the second-to-last coin.
	                );

	                // Choose the maximum of the two options (pickFirst or pickLast).
	                dp[i][j] = Math.max(pickFirst, pickLast);
	            }
	        }
	    }
	    // Return the optimal result for the entire range (0 to n-1).
	    return dp[0][n - 1];
	}


	// Method to calculate the DP table that represents the optimal strategy for all
	// subarrays of coins.
	private int[][] calculateOptimalDPTable(LinkedList<Integer> coins) {
	    int n = coins.size(); // Get the number of coins.

	    // Create a 2D DP array to store results of subproblems.
	    int[][] dp = new int[n][n];

	    // Loop over all possible subarray lengths from 1 to n.
	    for (int length = 1; length <= n; length++) {
	        // For each subarray length, process all subarrays of that length.
	        for (int i = 0; i <= n - length; i++) {
	            int j = i + length - 1; // End index of the current subarray.

	            // Directly calculate and store the maximum of the two options:
	            // - Pick the first coin, and the opponent plays optimally on the remaining
	            // coins.
	            // - Pick the last coin, and the opponent plays optimally on the remaining
	            // coins.
	            dp[i][j] = Math.max(
	                coins.get(i) + Math.min(
	                    (i + 2 <= j) ? dp[i + 2][j] : 0, // Option 1: opponent picks the second coin.
	                    (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0 // Option 2: opponent picks a coin from the middle.
	                ),
	                coins.get(j) + Math.min(
	                    (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0, // Option 1: opponent picks the first coin.
	                    (i <= j - 2) ? dp[i][j - 2] : 0 // Option 2: opponent picks the second-to-last coin.
	                )
	            );
	        }
	    }

	    // Return the DP table that contains the results for all subarrays.
	    return dp;
	}


	// Method to create a GridPane that visualizes the dynamic programming table for
	// optimal game play.
	private GridPane createDPGridPane(LinkedList<Integer> coins, int[][] dp) {
		GridPane gridPane = new GridPane(); // Create a new GridPane to display the DP table.
		gridPane.setHgap(10); // Set horizontal gap between cells.
		gridPane.setVgap(10); // Set vertical gap between cells.

		int n = coins.size(); // Get the number of coins.

		// Add header row for coin values at the top of the grid (for columns).
		for (int i = 0; i < n; i++) {
			Label headerLabel = new Label(String.valueOf(coins.get(i))); // Create label for each coin value.
			headerLabel.setStyle("-fx-font-size: 15px;-fx-font-weight: bold;-fx-text-fill: #DAA520;"); // Styling for
																										// header.
			gridPane.add(headerLabel, i + 1, 0); // Place the header in the first row, starting from column 1.
		}

		// Add header column for coin values on the left side of the grid (for rows).
		for (int j = 0; j < n; j++) {
			Label rowLabel = new Label(String.valueOf(coins.get(j))); // Create label for each coin value.
			rowLabel.setStyle("-fx-font-size: 15px;-fx-font-weight: bold;-fx-text-fill: #DAA520;"); // Styling for row
																									// headers.
			gridPane.add(rowLabel, 0, j + 1); // Place the row header in the first column, starting from row 1.
		}

		// Add the actual DP table values to the grid.
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				String cellValue;
				if (i <= j) {
					cellValue = String.valueOf(dp[i][j]); // Use the DP value for valid subarrays.
				} else {
					cellValue = "0"; // Fill empty spaces with zero (for invalid subarrays).
				}
				Label cellLabel = new Label(cellValue); // Create a label for each DP value.
				cellLabel.setStyle(
						"-fx-font-size: 10px;-fx-border-color: none;-fx-font-weight: bold; -fx-padding: 5;-fx-text-fill: white;");
				gridPane.add(cellLabel, j + 1, i + 1); // Add the cell to the grid at the appropriate position.
			}
		}

		return gridPane; // Return the constructed GridPane.
	}

	// Method to show a simple information alert with a message.
	private void showAlert(String message) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION); // Create an information alert.
		alert.setHeaderText(null); // Set the header to null (no title).
		alert.setContentText(message); // Set the content text of the alert to the provided message.
		alert.showAndWait(); // Display the alert and wait for user interaction.
	}

	// Method to show an information alert with an image as the background.
	public void showAlertWithImage(String message, String imagePath) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION); // Create an information alert.
		alert.setHeaderText(null); // Set the header to null (no title).
		alert.setTitle(" "); // Set an empty title for the alert.

		// Create a label to display the message in the alert.
		Label messageLabel = new Label(message);
		messageLabel.setStyle("-fx-font-size: 18px; -fx-text-alignment: center; -fx-text-fill: white;");
		messageLabel.setWrapText(true); // Allow text to wrap if it's too long.

		VBox content = new VBox(messageLabel); // Create a VBox to hold the message label.
		content.setAlignment(Pos.CENTER); // Align the content in the center.

		// Set the style for the alert's dialog pane, including a background image and
		// styling.
		alert.getDialogPane()
				.setStyle("-fx-background-image: url('" + imagePath + "');" + "-fx-background-size: cover;"
						+ "-fx-background-position: center;" + "-fx-background-color : #6B8E23;"
						+ "-fx-background-repeat: no-repeat;" + "-fx-font-size: 20px;" + "-fx-font-family: Arial;"
						+ "-fx-border-color: none;");

		// Set the dialog pane content and remove the default graphic.
		alert.getDialogPane().setContent(content);
		alert.setGraphic(null);

		// Customize the OK button appearance in the dialog.
		alert.getDialogPane().lookupButton(ButtonType.OK).setStyle(
				"-fx-background-color: none; -fx-border-color: none; -fx-cursor: hand; -fx-text-fill: white;");

		alert.getDialogPane().setPrefSize(350, 200); // Set a custom size for the alert.
		alert.showAndWait(); // Show the alert and wait for user interaction.
	}

	// Entry point for the application. Launches the JavaFX application.
	public static void main(String[] args) {
		launch(args); // Start the JavaFX application.
	}
}