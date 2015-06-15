/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.elle.analyster;

/**
 *
 * @author Tina
 */


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogWindow extends JFrame{
    
	private final JScrollPane scrollPane;
	private final TextArea logText;
	private final String FILENAME = "log.txt";
        private final ArrayList<LogMessage> logMessages = new ArrayList<>();
        private final JPanel jPanelLogWindowButtons;
        private final JButton jBtnClearAll;
        private final JButton jBtnClearAllButToday;
        private final JCheckBox jCheckBoxOrder;
        private final JLabel jLabelOrder;
        private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");

        // constructor
	public LogWindow() {
		
		this.setTitle("Log Window");
		ImageIcon imag = new ImageIcon(
				"Images/elle gui image.jpg");
		this.setIconImage(imag.getImage());

		logText = new TextArea(5, 30);
		logText.setEditable(false);
		scrollPane = new JScrollPane(logText);
		
                // change layout of frame
                this.setLayout(new GridBagLayout());
                
                // set constraints for the scroll panel
                GridBagConstraints scrollPanelConstraints = new GridBagConstraints();
                scrollPanelConstraints.fill = GridBagConstraints.BOTH;
                scrollPanelConstraints.weightx = 1; // takes up whole x axis
                scrollPanelConstraints.weighty = 1; // takes up most y axis with room for buttons
                scrollPanelConstraints.gridx = 0; // first col cell
                scrollPanelConstraints.gridy = 0; // first row cell
                
                // add scroll panel to frame
		this.add(scrollPane, scrollPanelConstraints);
                
                // create a panel for buttons
                jPanelLogWindowButtons = new JPanel();
                
                // create buttons 
                jBtnClearAll = new JButton("Clear All");
                jBtnClearAll.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jBtnClearAllActionPerformed(evt);
                    }
                });
                jBtnClearAllButToday = new JButton("Clear All But Today");
                jBtnClearAllButToday.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jBtnClearAllButTodayActionPerformed(evt);
                    }
                });
                jCheckBoxOrder = new JCheckBox();
                jCheckBoxOrder.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jCheckBoxOrderActionPerformed(evt);
                    }
                });
                jLabelOrder = new JLabel("Order");
                
                // add buttons to panel
                jPanelLogWindowButtons.add(jBtnClearAll);
                jPanelLogWindowButtons.add(jBtnClearAllButToday);
                jPanelLogWindowButtons.add(jCheckBoxOrder);
                jPanelLogWindowButtons.add(jLabelOrder);
                
                // set constraints for the buttons panel
                GridBagConstraints buttonsPanelConstraints = new GridBagConstraints();
                buttonsPanelConstraints.fill = GridBagConstraints.HORIZONTAL;
                buttonsPanelConstraints.weightx = 1; // takes up whole x axis
                buttonsPanelConstraints.weighty = 0; // takes up enough y axis just for buttons
                buttonsPanelConstraints.gridx = 0; // first col cell
                buttonsPanelConstraints.gridy = 1; // second row cell
                
                // add panel to the frame
                this.add(jPanelLogWindowButtons,buttonsPanelConstraints);
                
                this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.pack();
		this.setVisible(false);    
                
                // write to log file
                Date date = new Date();
                writeToTextFile("-------------------------" + dateFormat.format(date) + "-------------------------"); 
                
                // read log messages from the log file
		readMessages();
	}

	public String fillSQLCommand(String str) {

		String output;
		if (str.startsWith("#")) {
			output = "SELECT *\nFROM trades\nWHERE Symbol = " + "'"
					+ str.substring(1) + "'";
		} else {
			String[] lst = str.split(" ");
			output = "SELECT *\nFROM trades\nWHERE Trade_Time BETWEEN " + "'"
					+ lst[0].substring(1) + "' AND '" + lst[1] + "'";
		}
		return output;
	}

	public void sendMessages(String str) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss a");
		writeToTextFile(dateFormat.format(date) + ": " + str);
		readCurrentMessages(dateFormat.format(date) + ": " + str);
	}

	public void readCurrentMessages(String str) {
		logText.append(str);
		logText.append("\n");
	}

	public void readMessages() {
		String line = "";
		try {
			FileReader fileReader = new FileReader(FILENAME);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			line = bufferedReader.readLine();
			while (line != null) {
				logText.append(line);
				logText.append("\n");
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this,
					"Error: Fail to read the log file");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Unknown error");
		}
	}

	public void writeToTextFile(String str) {
		File file = new File(FILENAME);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(FILENAME, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(str);
			bufferedWriter.newLine();
			if (str.endsWith("\n"))
				bufferedWriter.newLine();
			bufferedWriter.close();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this,
					"Error: Fail to write the log file");
		} catch (Exception ex) {
			JOptionPane.showConfirmDialog(this, "Unknow error");
		}
	}
        
        /**
         * Clear all button: When the Clear all button is clicked, 
         * all the messages are removed from the scroll pane text box.
         */
        private void jBtnClearAllActionPerformed(ActionEvent evt) {
            logText.setText(""); 
        }
        
        /**
         * Clear all but today button action performed: 
         * When the Clear all but today button is clicked, 
         * all the messages are removed from the scroll panel text box,
         * except todays.
         */
        private void jBtnClearAllButTodayActionPerformed(ActionEvent evt) {
            
            // store log messages in an array of log messages
            storeLogMessages(); // get most current messages to array
            
            // get the order of messages
            if(jCheckBoxOrder.isSelected()){
                // sorts by most recent date first
                Collections.sort(logMessages, new LogMessage.SortByMostRecentDateFirst());
            }else if(!jCheckBoxOrder.isSelected()){
                // sorts by least recent date first
                Collections.sort(logMessages, new LogMessage.SortByLeastRecentDateFirst());
            }
                
            // compare date with todays date and print to screen
            Date date = new Date(); // get todays date
            logText.setText(""); // clear text box
            for(LogMessage logMessage : logMessages){
                
                // if date is today then print to screen
                if(logMessage.getDate().getYear() == date.getYear() 
                        && logMessage.getDate().getDay()== date.getDay()){
                    logText.append("-------------------------" + dateFormat.format(logMessage.getDate()) + "-------------------------");
                    logText.append(logMessage.getMessage());
                }
            }  
        }
        
        /**
         * Order check box: When the order check box is checked, 
         * all the messages are reversed in order in the scroll pane text box.
         */
        private void jCheckBoxOrderActionPerformed(ActionEvent evt) {
            
            // store log messages in an array of log messages
            storeLogMessages(); // get most current messages to array
            
            // sort log messages
            if(jCheckBoxOrder.isSelected()){
                // sorts by most recent date first
                Collections.sort(logMessages, new LogMessage.SortByMostRecentDateFirst());
            }else if(!jCheckBoxOrder.isSelected()){
                // sorts by least recent date first
                Collections.sort(logMessages, new LogMessage.SortByLeastRecentDateFirst());
            }
            
            logText.setText("");// clear text box
            // print log messages to log window text box
            for (LogMessage logMessage : logMessages) {
                logText.append("-------------------------" + dateFormat.format(logMessage.getDate()) + "-------------------------");
                logText.append(logMessage.getMessage());
            }
        }
        
        /**
         * storeLogMessages: Method
         * Stores each LogMessage object in an array. 
         * This is to be able to easily retrieve specific data according to specific times or dates.
         */
        private void storeLogMessages(){
            
            File file = new File(FILENAME);
            String FIELD_SEP = "-------------------------";
            logMessages.clear(); // clear array of any elements
            Date date = new Date();
            String message = "";
		
            if (file.exists())  // prevent the FileNotFoundException
            {
                try
                {
                    
                    BufferedReader in = 
                         new BufferedReader(
                         new FileReader(FILENAME));

                    // read all log messages stored in the log file
                    // and store them into the array list
                    String line = in.readLine(); // start while loop if not empty
                    while(line != null)
                    {
                        if(line.startsWith("----")){
                            String[] columns = line.split(FIELD_SEP);
                            date = dateFormat.parse(columns[1]);
                            message = ""; // reset message string
                            
                            line = in.readLine();
                        }
                        else{
                            message = message + "\n" + line;
                            line = in.readLine();
                            if(line == null || line.startsWith("----")){
                                logMessages.add(new LogMessage(date, message));  
                            }
                        }                  
                    }

                    in.close(); // close the input stream
                }
                catch(IOException e){e.printStackTrace();} 
                catch (ParseException ex) { ex.printStackTrace();} 
            }  
        }

    /**
     * LogMessages class
     * this class stores log message information
     */
    private static class LogMessage {

        private final Date date;
        private final String message;
        
        public LogMessage(Date date, String message) {
            this.date = date;
            this.message = message;
        }
        
        public Date getDate(){ return date;}
        public String getMessage(){return message;}
        
        public static class SortByMostRecentDateFirst implements Comparator<LogMessage>
        {
            @Override
            public int compare(LogMessage c, LogMessage c1) {
                return c.getDate().compareTo(c1.getDate());
            }    
        }
        
        public static class SortByLeastRecentDateFirst implements Comparator<LogMessage>
        {
            @Override
            public int compare(LogMessage c, LogMessage c1) {
                return c1.getDate().compareTo(c.getDate());
            }    
        }
    }
}

