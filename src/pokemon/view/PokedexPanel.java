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
	
	private JButton changeButton; 
	private JComboBox<String> pokedexDropdown;
	
	private ImageIcon pokemonIcon;

	public PokedexPanel(PokedexController app)
	{
		super();
		this.app = app;
		this.appLayout = new SpringLayout();
		this.pokemonIcon = new ImageIcon(getClass().getResource("/pokemon/view/images/PMflareon.jpeg")); //default image
		
		numberField = new JTextField("0");
		numberField.setEnabled(false);
		nameField = new JTextField("My pokename");
		evolveField = new JTextField("true");
		attackField = new JTextField("0");
		enhancementField = new JTextField("0");
		healthField = new JTextField("0");
		numberLabel = new JLabel("The pokemon number is ");
		nameLabel = new JLabel ("My name is ");
		evolveLabel = new JLabel ("This pokemon can evolve ");
		attackLabel = new JLabel ("This pokemon attack level is ");
		enhanceLabel = new JLabel ("This pokemon enhancement level is ");
		healthLabel = new JLabel ("This pokemon health is");
		imageLabel = new JLabel ("pokemon goes here", pokemonIcon, JLabel.CENTER);
		changeButton = new JButton("Click here to change the pokevalues");
		
		pokedexDropdown = new JComboBox<String>();

		
		
		setUpPanel();
		setUpLayout();
		setUpListeners();
		setUpDropdown();
	}
	
	private void setUpLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 0, SpringLayout.NORTH, changeButton);
		appLayout.putConstraint(SpringLayout.EAST, pokedexDropdown, 0, SpringLayout.EAST, nameLabel);
		
		appLayout.putConstraint(SpringLayout.NORTH, changeButton, 26, SpringLayout.SOUTH, imageLabel);
		appLayout.putConstraint(SpringLayout.WEST, changeButton, 10, SpringLayout.WEST, this);
		
		appLayout.putConstraint(SpringLayout.NORTH, imageLabel, 0, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, imageLabel, 0, SpringLayout.WEST, this);
		
		appLayout.putConstraint(SpringLayout.NORTH, numberField, 37, SpringLayout.NORTH, this);
		
		appLayout.putConstraint(SpringLayout.WEST, numberLabel, 65, SpringLayout.EAST, imageLabel);
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 65, SpringLayout.EAST, imageLabel);
		appLayout.putConstraint(SpringLayout.WEST, attackLabel, 62, SpringLayout.EAST, imageLabel);
		
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 16, SpringLayout.SOUTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 0, SpringLayout.WEST, numberLabel);
		
		appLayout.putConstraint(SpringLayout.NORTH, enhanceLabel, 22, SpringLayout.SOUTH, attackLabel);
		appLayout.putConstraint(SpringLayout.WEST, enhanceLabel, 0, SpringLayout.WEST, numberLabel);

		appLayout.putConstraint(SpringLayout.NORTH, attackField, -5, SpringLayout.NORTH, attackLabel);
		appLayout.putConstraint(SpringLayout.WEST, attackField, 91, SpringLayout.EAST, attackLabel);
		appLayout.putConstraint(SpringLayout.NORTH, attackLabel, 16, SpringLayout.SOUTH, evolveLabel);
		
		appLayout.putConstraint(SpringLayout.NORTH, evolveField, -5, SpringLayout.NORTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.NORTH, evolveLabel, 85, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, numberLabel, -24, SpringLayout.NORTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolveLabel, 0, SpringLayout.WEST, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 10, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, numberField, 116, SpringLayout.EAST, numberLabel);
		
		appLayout.putConstraint(SpringLayout.NORTH, healthField, 6, SpringLayout.SOUTH, enhancementField);
		appLayout.putConstraint(SpringLayout.EAST, healthField, 0, SpringLayout.EAST, numberField);
		
		appLayout.putConstraint(SpringLayout.NORTH, enhancementField, 6, SpringLayout.SOUTH, attackField);
		appLayout.putConstraint(SpringLayout.EAST, enhancementField, 0, SpringLayout.EAST, numberField);
		
		appLayout.putConstraint(SpringLayout.WEST, evolveField, 0, SpringLayout.WEST, attackField);

		appLayout.putConstraint(SpringLayout.WEST, nameField, 0, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.SOUTH, nameField, -6, SpringLayout.NORTH, numberField);


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
		
		imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
		imageLabel.setHorizontalTextPosition(JLabel.CENTER);

	}
	

	
	private void setUpDropdown()
	{
		DefaultComboBoxModel<String> temp = new DefaultComboBoxModel<String>(app.buildPokedexText());
		pokedexDropdown.setModel(temp);
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
			public void actionPerformed(ActionEvent Click)
			{
				String name = pokedexDropdown.getSelectedItem().toString();
				changeImageDisplay(name);
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
			pokemonIcon = new ImageIcon(getClass().getResource(path + name.toLowerCase() + extension));
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
			
			//insert code here
			app.updatePokemon(index, data);
		}
	}
	

}
