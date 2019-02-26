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
		numberField.setEnabled(false);
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
		appLayout.putConstraint(SpringLayout.NORTH, nameField, 5, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, numberField, 0, SpringLayout.EAST, evolveField);
		appLayout.putConstraint(SpringLayout.EAST, evolveField, 0, SpringLayout.EAST, attackField);

		
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 36, SpringLayout.SOUTH, changeButton);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 0, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.EAST, enhancementField, -285, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, attackField, 0, SpringLayout.EAST, enhancementField);
		appLayout.putConstraint(SpringLayout.WEST, enhancementField, 43, SpringLayout.EAST, enhanceLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolveField, 109, SpringLayout.EAST, evolveLabel);

		appLayout.putConstraint(SpringLayout.EAST, healthField, -285, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, enhancementField, -6, SpringLayout.NORTH, healthField);

		
		appLayout.putConstraint(SpringLayout.WEST, nameField, 198, SpringLayout.EAST, nameLabel);
		appLayout.putConstraint(SpringLayout.EAST, nameField, 330, SpringLayout.EAST, nameLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthField, 125, SpringLayout.EAST, healthLabel);

		appLayout.putConstraint(SpringLayout.NORTH, imageLabel, 19, SpringLayout.SOUTH, healthLabel);
		appLayout.putConstraint(SpringLayout.WEST, imageLabel, 28, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, pokedexDropdown, -53, SpringLayout.NORTH, changeButton);
		
		appLayout.putConstraint(SpringLayout.EAST, pokedexDropdown, -207, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, changeButton, 334, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, changeButton, -176, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, attackLabel, 186, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 189, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, numberLabel, 189, SpringLayout.WEST, this);
		
		appLayout.putConstraint(SpringLayout.NORTH, healthField, 176, SpringLayout.NORTH, this);
		

		appLayout.putConstraint(SpringLayout.NORTH, numberField, 37, SpringLayout.NORTH, this);
		
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
			public void actionPerformed(ActionEvent Click)
			{
				String name = pokedexDropdown.getSelectedItem().toString();
				changeImageDisplay(name);
			}
		});
		
		saveButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent Click)
			{
				//app.savePokedex();
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
			data[0] = "0"; //d i s b
			data[1] = "0.0";
			data[2] = "0";
			data[3] = "name";
			data[4] = "true";
		
			app.updatePokemon(index, data);
		}
	}
	

}
