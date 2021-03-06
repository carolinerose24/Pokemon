package pokemon.view;
import javax.swing.*;

import pokemon.controller.PokedexController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;


public class PokedexPanel extends JPanel
{
	private SpringLayout appLayout;
	private PokedexController app;
	
	private JTextField numberField;
	private JTextField nameField;
	private JTextField evolveField;
	private JTextField attackField;
	private JTextField enhancementField;
	private JTextField healthField;
	
	private JLabel numberLabel;
	private JLabel nameLabel;
	private JLabel evolveLabel;
	private JLabel attackLabel;
	private JLabel enhanceLabel;
	private JLabel healthLabel;
	private JLabel imageLabel;
	
	private JButton saveButton;
	private JButton changeButton; 
	private JComboBox<String> pokedexDropdown;
	
	private ImageIcon pokemonIcon;

	public PokedexPanel(PokedexController app)
	{
		super();
		this.app = app;
		this.appLayout = new SpringLayout();
		this.pokemonIcon = new ImageIcon(getClass().getResource("/pokemon/view/images/Flareon.jpeg")); //default image
		
		numberField = new JTextField("136");
		numberField.setEditable(false);
		nameField = new JTextField("Flareon");

		
		evolveField = new JTextField("true");



		attackField = new JTextField("50");


		enhancementField = new JTextField("20");


		healthField = new JTextField("100");


		numberLabel = new JLabel("The pokemon number is ");

		nameLabel = new JLabel ("My name is ");


		
		evolveLabel = new JLabel ("This pokemon can evolve ");


		attackLabel = new JLabel ("This pokemon attack level is ");
		enhanceLabel = new JLabel ("This pokemon enhancement level is ");


		healthLabel = new JLabel ("This pokemon health is");

		imageLabel = new JLabel (" ", pokemonIcon, JLabel.CENTER);

		
		changeButton = new JButton("Click here to change the pokevalues");
		saveButton = new JButton("Save");
	
		pokedexDropdown = new JComboBox<String>();

		
		setUpPanel();
		setUpLayout();
		setUpListeners();
		setUpDropdown();
	}
	
	private void setUpLayout()
	{
		
		appLayout.putConstraint(SpringLayout.NORTH, numberField, 6, SpringLayout.SOUTH, nameField);
		appLayout.putConstraint(SpringLayout.WEST, numberField, 0, SpringLayout.WEST, nameField);
		appLayout.putConstraint(SpringLayout.EAST, numberField, -20, SpringLayout.EAST, nameField);
		appLayout.putConstraint(SpringLayout.EAST, nameField, -114, SpringLayout.EAST, this);
		
		appLayout.putConstraint(SpringLayout.EAST, evolveField, -124, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, numberField, -19, SpringLayout.NORTH, evolveField);
		appLayout.putConstraint(SpringLayout.NORTH, attackField, 6, SpringLayout.SOUTH, evolveField);
		appLayout.putConstraint(SpringLayout.EAST, attackField, -149, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, enhancementField, 17, SpringLayout.SOUTH, attackField);
		appLayout.putConstraint(SpringLayout.EAST, enhancementField, 25, SpringLayout.EAST, nameField);
		
		appLayout.putConstraint(SpringLayout.NORTH, healthField, 201, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, enhancementField, -6, SpringLayout.NORTH, healthField);
		appLayout.putConstraint(SpringLayout.EAST, healthField, -51, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, nameField, -5, SpringLayout.NORTH, nameLabel);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 157, SpringLayout.EAST, nameLabel);
		
		appLayout.putConstraint(SpringLayout.NORTH, evolveField, -5, SpringLayout.NORTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolveField, 68, SpringLayout.EAST, evolveLabel);
		appLayout.putConstraint(SpringLayout.WEST, attackField, 50, SpringLayout.EAST, attackLabel);

		appLayout.putConstraint(SpringLayout.WEST, enhancementField, 4, SpringLayout.EAST, enhanceLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthField, 72, SpringLayout.EAST, healthLabel);

		
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 6, SpringLayout.SOUTH, imageLabel);
		appLayout.putConstraint(SpringLayout.WEST, pokedexDropdown, 43, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, pokedexDropdown, -10, SpringLayout.EAST, imageLabel);
		
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 50, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, numberLabel, -324, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 15, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, nameLabel, -406, SpringLayout.EAST, this);
		
		appLayout.putConstraint(SpringLayout.EAST, attackLabel, -299, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, evolveLabel, 90, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, evolveLabel, -317, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, enhanceLabel, -251, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, healthLabel, -333, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, imageLabel, 0, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, imageLabel, 33, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 462, SpringLayout.WEST, this);

		
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 36, SpringLayout.SOUTH, changeButton);
		appLayout.putConstraint(SpringLayout.NORTH, changeButton, 334, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, changeButton, -176, SpringLayout.EAST, this);
		
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 16, SpringLayout.SOUTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 0, SpringLayout.WEST, numberLabel);
		
		appLayout.putConstraint(SpringLayout.NORTH, enhanceLabel, 22, SpringLayout.SOUTH, attackLabel);
		appLayout.putConstraint(SpringLayout.WEST, enhanceLabel, 0, SpringLayout.WEST, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, attackLabel, 16, SpringLayout.SOUTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, numberLabel, -24, SpringLayout.NORTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolveLabel, 0, SpringLayout.WEST, numberLabel);



	}
	
	private void setUpPanel()
	{
		this.setLayout(appLayout);
		//this.setPreferredSize(new Dimension(800,600));
		//this.setBackground(Color.PINK);
		
		this.add(changeButton);
		this.add(pokedexDropdown);
		
		this.add(numberField);
		this.add(nameField);
		this.add(evolveField);
		this.add(attackField);
		this.add(enhancementField);
		this.add(healthField);
		
		this.add(numberLabel);
		this.add(nameLabel);
		this.add(evolveLabel);
		this.add(attackLabel);
		this.add(enhanceLabel);
		this.add(healthLabel);
		this.add(imageLabel);
		
		this.add(saveButton);
		
		imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
		imageLabel.setHorizontalTextPosition(JLabel.CENTER);

	}
	

	
	private void setUpDropdown()
	{
		DefaultComboBoxModel<String> temp = new DefaultComboBoxModel<String>(app.buildPokedexText());
		pokedexDropdown.setModel(temp);
		
		//set same pokemon's data here?
	}
	
	private void setUpListeners()
	{
		changeButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				sendDataToController();
			}
		});
		
		pokedexDropdown.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent selected)
			{
				String name = pokedexDropdown.getSelectedItem().toString();
				updateFields(pokedexDropdown.getSelectedIndex());
				changeImageDisplay(name);
			}
		});
		
		saveButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent Click)
			{
				app.savePokedex();

			}
		});
		
		
	}

	private void changeImageDisplay(String name)
	{
		String path = "/pokemon/view/images/";
		String defaultName = "Flareon";
		String extension = ".jpeg";
		
		try
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + name + extension)); // .toLowerCase() + extension));
		}
		catch (NullPointerException missingFile)
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		imageLabel.setIcon(pokemonIcon);
		repaint();
		
	}
	
	private void sendDataToController()
	{
		int index = pokedexDropdown.getSelectedIndex();
		if(app.isInt(attackField.getText()) && app.isDouble(enhancementField.getText()) && app.isInt(healthField.getText()))
		{
			String [] data = new String[5];
			
			data[0] = attackField.getText(); //d i s b
			data[1] = enhancementField.getText();
			data[2] = healthField.getText();
			data[3] = evolveField.getText();
			data[4] = numberField.getText();
		
			app.updatePokemon(index, data);
		}
	}
	
	private void updateFields(int index)
	{
		String [] data = app.getPokeData(index);
		
		attackField.setText(data[0]);
		enhancementField.setText(data[1]);
		healthField.setText(data[2]);
		evolveField.setText(data[4]);
		numberField.setText(data[5]);
		//nameField.setText(data[3]);
	}
	
	
}
