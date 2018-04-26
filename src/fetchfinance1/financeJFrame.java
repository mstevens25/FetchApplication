/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fetchfinance1;
import java.awt.Color;
import static java.lang.Double.parseDouble;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Kat
 */
public class financeJFrame extends javax.swing.JInternalFrame {

    
//    Connection con = null;
//    PreparedStatement pst = null;
//    ResultSet rs = null;
    /**
     * Creates new form financeJFrame
     */
    public financeJFrame() {
        initComponents();
        showJournals();
        showInvoice();
    }
    
    // function to connect to mysql database
   
     public ArrayList<journalModel> listJournals()
    {
        ArrayList<journalModel> journalList = new ArrayList<journalModel>();
        
        Statement st = null;
        ResultSet rs = null;
        Connection con = null;
        try{
            
            con = DriverManager.getConnection("jdbc:mysql://fetch-mobile-grooming.mysql.database.azure.com/Fetchdb","malderson@fetch-mobile-grooming","Puppy123");
            st = con.createStatement();
            String query = "SELECT * FROM financedb.journal";
            rs = st.executeQuery(query);
            
            journalModel journal;
            
            while(rs.next())
            {
                journal = new journalModel(rs.getInt("entryId"),(rs.getDate("entryDate")),rs.getString("entryType"),rs.getString("entryStmt"));
            
                journalList.add(journal);
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            try { rs.close(); } catch (Exception e) { /* ignored */ }
            try { st.close(); } catch (Exception e) { /* ignored */ }
            try { con.close(); } catch (Exception e) { /* ignored */ }
        }
        return journalList;
    }
     
     public void showJournals()
    {
        ArrayList<journalModel> journals = listJournals();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Entry ID","Entry Date","Entry Type"});
        Object[] row = new Object[3];
        
        for(int i = 0; i < journals.size(); i++)
        {
            row[0] = journals.get(i).getEntryId();
            row[1] = journals.get(i).getEntryDate();
            row[2] = journals.get(i).getEntryType();
            model.addRow(row);
        }
       jTable2.setModel(model);
       
    }
     public ArrayList<invoiceModel> listInvoice()
    {
        ArrayList<invoiceModel> invoiceList = new ArrayList<invoiceModel>();
        
        Statement st = null;
        ResultSet rs = null;
        Connection con = null;
        try{
            
            con = DriverManager.getConnection("jdbc:mysql://fetch-mobile-grooming.mysql.database.azure.com/Fetchdb","malderson@fetch-mobile-grooming","Puppy123");
            st = con.createStatement();
            String query = "SELECT * FROM financedb.invoice";
            rs = st.executeQuery(query);
            
            invoiceModel invoice;
            
            while(rs.next())
            {
                invoice = new invoiceModel(rs.getInt("invoiceId"),(rs.getDate("invoiceDate")),rs.getString("invoiceType"),rs.getDouble("invoiceTotal"),rs.getString("invoiceSource"),rs.getString("invoiceTags"));
            
                invoiceList.add(invoice);
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            try { rs.close(); } catch (Exception e) { /* ignored */ }
            try { st.close(); } catch (Exception e) { /* ignored */ }
            try { con.close(); } catch (Exception e) { /* ignored */ }
        }
        return invoiceList;
    }
     
     public void showInvoice()
    {
        DecimalFormat twoDigits = new DecimalFormat("$#,###.00");
        ArrayList<invoiceModel> invoice = listInvoice();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Invoice ID","Invoice Date","Invoice Type", "Invoice Total","Invoice Source","Invoice Tags"});
        Object[] row = new Object[6];
        
        for(int i = 0; i < invoice.size(); i++)
        {
            row[0] = invoice.get(i).getInvoiceId();
            row[1] = invoice.get(i).getInvoiceDate();
            row[2] = invoice.get(i).getInvoiceType();
            row[3] = twoDigits.format(invoice.get(i).getInvoiceTotal());
            row[4] = invoice.get(i).getInvoiceSource();
            row[5] = invoice.get(i).getInvoiceTags();
            model.addRow(row);
        }
       jTable1.setModel(model);
       
    }
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        jMenu3 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        menuBar3 = new java.awt.MenuBar();
        menu5 = new java.awt.Menu();
        menu6 = new java.awt.Menu();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        label2 = new java.awt.Label();
        sortChoice1 = new java.awt.Choice();
        sortChoice1.add("Date");
        sortChoice1.add("Type");
        sortChoice1.add("Total");
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        yearChoice1 = new java.awt.Choice();
        yearChoice1.add("2015");
        yearChoice1.add("2016");
        yearChoice1.add("2017");
        yearChoice1.add("2018");
        label5 = new java.awt.Label();
        jSeparator1 = new javax.swing.JSeparator();
        label6 = new java.awt.Label();
        label7 = new java.awt.Label();
        label8 = new java.awt.Label();
        jSeparator2 = new javax.swing.JSeparator();
        checkbox1 = new java.awt.Checkbox();
        checkbox2 = new java.awt.Checkbox();
        checkbox3 = new java.awt.Checkbox();
        checkbox4 = new java.awt.Checkbox();
        checkbox5 = new java.awt.Checkbox();
        apButton = new java.awt.Button();
        apEndDate = new org.jdesktop.swingx.JXDatePicker();
        apStartDate = new org.jdesktop.swingx.JXDatePicker();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        sortChoice2 = new java.awt.Choice();
        sortChoice2.add("Date");
        sortChoice2.add("Type");
        sortChoice2.add("Total");
        jLabel10 = new javax.swing.JLabel();
        choice4 = new java.awt.Choice();
        choice4.add("2015");
        choice4.add("2016");
        choice4.add("2017");
        choice4.add("2018");
        jLabel11 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        checkbox6 = new java.awt.Checkbox();
        checkbox7 = new java.awt.Checkbox();
        checkbox8 = new java.awt.Checkbox();
        checkbox9 = new java.awt.Checkbox();
        arButton = new java.awt.Button();
        arEndDate = new org.jdesktop.swingx.JXDatePicker();
        arStartDate = new org.jdesktop.swingx.JXDatePicker();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        sortChoice3 = new java.awt.Choice();
        sortChoice3.add("Date");
        sortChoice3.add("Type");
        sortChoice3.add("Amount Ascending");
        sortChoice3.add("Amount Descending");
        yearChoice3 = new java.awt.Choice();
        yearChoice3.add("2015");
        yearChoice3.add("2016");
        yearChoice3.add("2017");
        yearChoice3.add("2018");
        jLabel18 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        button2 = new java.awt.Button();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();
        jPanel4 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        button3 = new java.awt.Button();
        button5 = new java.awt.Button();
        panel1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        choice1 = new java.awt.Choice();
        invTypeChoice = new java.awt.Choice();
        invTypeChoice.add("Credit");
        invTypeChoice.add("Debit");
        jLabel4 = new javax.swing.JLabel();
        choice3 = new java.awt.Choice();
        invSourceChoice = new java.awt.Choice();
        invSourceChoice.removeAll();
        invSourceChoice.add("Sale");
        invSourceChoice.add("Endoresment");
        invSourceChoice.add("Grant");
        invSourceChoice.add("Payment/Royalty");
        label9 = new java.awt.Label();
        label11 = new java.awt.Label();
        jLabel5 = new javax.swing.JLabel();
        invTagTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        invAmntTextField = new javax.swing.JTextField();
        madeInvoiceLabel = new javax.swing.JLabel();
        invDate = new org.jdesktop.swingx.JXDatePicker();
        panel2 = new java.awt.Panel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        jMenu3.setText("jMenu3");

        menu5.setLabel("File");
        menuBar3.add(menu5);

        menu6.setLabel("Edit");
        menuBar3.add(menu6);

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrame1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        label1.setBackground(new java.awt.Color(255, 255, 255));
        label1.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        label1.setText("Fetch Reports");

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        label2.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        label2.setText("Generate an accoutns payable report");

        label3.setText("Sort By");

        label4.setText("Fiscal Year");

        yearChoice1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                yearChoice1ItemStateChanged(evt);
            }
        });

        label5.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        label5.setText("Dates");

        jSeparator1.setForeground(new java.awt.Color(167, 213, 39));

        label6.setText("Start Date: ");

        label7.setText("End Date: ");

        label8.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        label8.setText("Filters");

        jSeparator2.setForeground(new java.awt.Color(167, 213, 39));

        checkbox1.setLabel("Payroll");
        checkbox1.setState(true);

        checkbox2.setLabel("Products");
        checkbox2.setState(true);

        checkbox3.setLabel("Utitlities");
        checkbox3.setState(true);

        checkbox4.setLabel("Services");
        checkbox4.setState(true);

        checkbox5.setLabel("Other");
        checkbox5.setState(true);

        apButton.setLabel("Generate Report");
        apButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)
                                        .addComponent(sortChoice1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)))
                                .addComponent(yearChoice1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(checkbox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(checkbox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(checkbox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(checkbox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(checkbox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(314, 314, 314)
                                .addComponent(apButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(apStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(138, 138, 138)
                                .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(apEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 117, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(yearChoice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sortChoice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(51, 51, 51)
                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(apStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(apEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkbox3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkbox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkbox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkbox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(checkbox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(apButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Accounts Payable", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel8.setText("Generate an accounts receivable report ");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Sort By: ");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Fiscal year");

        choice4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choice4ItemStateChanged(evt);
            }
        });
        choice4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                choice4FocusLost(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Dates");

        jSeparator3.setForeground(new java.awt.Color(167, 213, 39));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Start Date:");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("End Date: ");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Filters");

        jSeparator4.setForeground(new java.awt.Color(167, 213, 39));

        checkbox6.setLabel("Sales");
        checkbox6.setName("Sales"); // NOI18N
        checkbox6.setState(true);

        checkbox7.setLabel("Endorsements");
        checkbox7.setState(true);

        checkbox8.setLabel("Grants");
        checkbox8.setState(true);

        checkbox9.setLabel("Payments/Royalties");
        checkbox9.setState(true);

        arButton.setLabel("Generate Report");
        arButton.setName(""); // NOI18N
        arButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addComponent(jSeparator4)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel9)
                        .addGap(1, 1, 1)
                        .addComponent(sortChoice2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(choice4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(arStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(arEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(checkbox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(checkbox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(checkbox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(checkbox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(arButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(sortChoice2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(choice4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGap(46, 46, 46)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(arStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(arEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkbox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkbox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkbox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkbox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(arButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Accounts Receiveable", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel15.setText("Generate a general ledger with details of the account journal");

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("Sort By: ");

        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setText("Fiscal Year: ");

        yearChoice3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                yearChoice3ItemStateChanged(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("Date");

        jSeparator5.setForeground(new java.awt.Color(167, 213, 39));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel19.setText("Start Date:");
        jLabel19.setToolTipText("");

        jLabel20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel20.setText("End Date:");

        button2.setLabel("Generate Ledger");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sortChoice3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yearChoice3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(214, 214, 214))))
            .addComponent(jSeparator5)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel18))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel15)
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel16))
                        .addComponent(jLabel17))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(yearChoice3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addComponent(sortChoice3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        jTabbedPane1.addTab("General Ledger", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel21.setText("View and edit journal entries");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EntryId", "Date", "Entry Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
        }

        button3.setLabel("Delete");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button5.setLabel("Open");
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel21))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        jTabbedPane1.addTab("Journals", jPanel4);

        panel1.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        jLabel1.setText("Manually create invoices");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Invoice Date :");

        jButton1.setText("Create Invoice");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Invoice Type:");

        invTypeChoice.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                invTypeChoiceItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Invoice Source ");

        label9.setText("label9");

        label11.setText("label11");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Tags :");

        invTagTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        invTagTextField.setToolTipText("Seperate tags by ,");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Invoice Amount: $");

        invAmntTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        invAmntTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                invAmntTextFieldFocusLost(evt);
            }
        });
        invAmntTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invAmntTextFieldActionPerformed(evt);
            }
        });

        madeInvoiceLabel.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        madeInvoiceLabel.setForeground(new java.awt.Color(0, 153, 0));
        madeInvoiceLabel.setToolTipText("");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(madeInvoiceLabel))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invTypeChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(invTagTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(invSourceChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(79, 79, 79)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(invAmntTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(invDate, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(invTypeChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(invSourceChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(invAmntTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(85, 85, 85)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invTagTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(invDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(madeInvoiceLabel)
                .addGap(26, 26, 26)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(65, 65, 65))
        );

        jTabbedPane1.addTab("Create Invoice", panel1);

        jLabel6.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        jLabel6.setText("Invoices");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"01/15/2016", "Debit", "$255.50", "Payroll", null},
                {"05/25/2016", "Credit", "$65.00", "Sale", "UNPAID"},
                {"03/26/2017", "Credit", "$170.00", "Endorsement", null},
                {"11/07/2017", "Debit", "$500.00", "Service", null}
            },
            new String [] {
                "Date", "Invoice Type", "Invoice Total", "Invoice Source", "Tags"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel6)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Invoices", panel2);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void invTypeChoiceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_invTypeChoiceItemStateChanged
        // TODO add your handling code here:
        String invType = (String) invTypeChoice.getSelectedItem();
        
        if(invType.equals(invTypeChoice.getItem(0))){
            
            invSourceChoice.removeAll();
            invSourceChoice.add("Sale");
            invSourceChoice.add("Endoresment");
            invSourceChoice.add("Grant");
            invSourceChoice.add("Payment/Royalty");
            
            
        }else{
            invSourceChoice.removeAll();
            invSourceChoice.add("Payroll");
            invSourceChoice.add("Products");
            invSourceChoice.add("Utilities");
            invSourceChoice.add("Services");
            invSourceChoice.add("Other");
            
        }
            
    }//GEN-LAST:event_invTypeChoiceItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        DecimalFormat twoDigits = new DecimalFormat("$#,###.00");
        SimpleDateFormat formatter =  new SimpleDateFormat("yyyy-MM-dd"); 
        double total;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
      
       Connection con = null;
       PreparedStatement pst = null;
       total = parseDouble(invAmntTextField.getText());
       
       try{
           con = DriverManager.getConnection("jdbc:mysql://fetch-mobile-grooming.mysql.database.azure.com/Fetchdb","malderson@fetch-mobile-grooming","Puppy123");
           String stmt;
           Date date = invDate.getDate();
           java.sql.Date sqlDate = new java.sql.Date(date.getTime());
           stmt = "INSERT INTO financedb.invoice (invoiceDate,invoiceType,invoiceTotal,invoiceSource,invoiceTags) VALUES (?,?,?,?,?);" ;
           pst = con.prepareStatement(stmt);
           
        pst.setDate(1, sqlDate);
        pst.setString(2,invTypeChoice.getSelectedItem());
        pst.setDouble(3,total);
        pst.setString(4,invSourceChoice.getSelectedItem());
        pst.setString(5,invTagTextField.getText());
        pst.executeUpdate();
           
    
            showInvoice();
            invAmntTextField.setText("");
            invTagTextField.setText("");
             JOptionPane.showMessageDialog(null, "The invoice has been successfully created");
             madeInvoiceLabel.setText("");  
       }catch(Exception ex){
           madeInvoiceLabel.setText("An error has occured");  
          System.out.println(ex.getMessage());
       }finally{
           try { pst.close(); } catch (Exception e) { /* ignored */ }
           try { con.close(); } catch (Exception e) { /* ignored */ }
       }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void invAmntTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_invAmntTextFieldFocusLost
        // TODO add your handling code here:
        
        try{
    
        Double invAmnt = Double.parseDouble(invAmntTextField.getText());
        invAmntTextField.setBackground(Color.white);

        }catch(Exception e){
        e.printStackTrace(); 
        invAmntTextField.setBackground(Color.red);
         System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_invAmntTextFieldFocusLost

    private void invAmntTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invAmntTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_invAmntTextFieldActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        invAmntTextField.setText("");
        invTagTextField.setText("");
        
        madeInvoiceLabel.setText(""); 
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void apButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apButtonActionPerformed
        
//        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
//        DateFormat formatter =  new SimpleDateFormat("yyyy-MM-dd");
//        DefaultTableModel model2 = (DefaultTableModel)jTable2.getModel();
//        
//        Connection con = null;
//
//        try{
//            Date start =  formatter.parse(formatter.format(arStartDate.getDate()));
//             Date end =  formatter.parse(formatter.format(arEndDate.getDate()));
//             java.sql.Date sqlStart = new java.sql.Date(start.getTime());
//             java.sql.Date sqlEnd = new java.sql.Date(end.getTime());
//           con = DriverManager.getConnection("jdbc:mysql://fetch-mobile-grooming.mysql.database.azure.com/Fetchdb","malderson@fetch-mobile-grooming","Puppy123");
//           String stmt;
//           String search = "SELECT * FROM financedb.invoice  WHERE (";
//           String sortBy ;
//           
//           if(checkbox1.getState()){  
//               search  = search.concat(" invoiceSource = 'Payroll' ");
//           }
//           if(checkbox2.getState()){
//              search = search.concat("OR invoiceSource = 'Products' ");
//           }
//           if(checkbox3.getState()){
//               search = search.concat("OR invoiceSource = 'Utilities' ");
//           }
//           if(checkbox4.getState()){
//               search = search.concat("OR invoiceSource = 'Services' ");
//           }
//           if(checkbox5.getState()){
//               search = search.concat("OR invoiceSource = 'Other' ");
//           }
//        
//           search = search.concat(") AND ");
//        
//          search = search.concat(" invoiceDate >= '" + sqlStart +"' AND invoiceDate <= '" + sqlEnd +"'");
//        
//            switch (sortChoice2.getSelectedIndex()) {
//                case 0:
//                    sortBy = "invoiceDate;";
//                    break;
//                case 1:
//                    sortBy = "invoiceType;";
//                    break;
//                default:
//                    sortBy = "invoiceTotal;";
//                    break;
//            }
//       
//        search = search.concat(" ORDER BY " + sortBy);
//        
//        
//        
//          stmt = "INSERT INTO financedb.journal (entryDate,entryType,entryStmt) VALUES (?,?,?);" ;
//           pst = con.prepareStatement(stmt);
//           
//        pst.setDate(1, date);
//        pst.setString(2,"Accounts Payable");
//        pst.setString(3,search);
//        pst.executeUpdate();
//           
//            
//               
//            
//            showJournals();
//            
//            
//           JOptionPane.showMessageDialog(null, "The journal entry has been created.");
//            DefaultTableModel model2 = (DefaultTableModel)jTable2.getModel();
        SimpleDateFormat formatter =  new SimpleDateFormat("yyyy-MM-dd");
       
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        Connection con = null;
       PreparedStatement pst = null;
        String stmt;
        
        try{
             Date start =  formatter.parse(formatter.format(arStartDate.getDate()));
             Date end =  formatter.parse(formatter.format(arEndDate.getDate()));
             java.sql.Date sqlStart = new java.sql.Date(start.getTime());
             java.sql.Date sqlEnd = new java.sql.Date(end.getTime());
           con = DriverManager.getConnection("jdbc:mysql://fetch-mobile-grooming.mysql.database.azure.com/Fetchdb","malderson@fetch-mobile-grooming","Puppy123");
           
           String search = "SELECT * FROM financedb.invoice  WHERE (";
           String sortBy ;
           
           
           if(checkbox1.getState()){  
               search  = search.concat(" invoiceSource = 'Payroll' ");
           }
           if(checkbox2.getState()){
              search = search.concat("OR invoiceSource = 'Products' ");
           }
           if(checkbox3.getState()){
               search = search.concat("OR invoiceSource = 'Utilites' ");
           }
           if(checkbox4.getState()){
               search = search.concat("OR invoiceSource = 'Services' ");
           }
           if(checkbox5.getState()){
               search = search.concat("OR invoiceSource = 'Other' ");
           }
        
           search = search.concat(") AND ");
        
          search = search.concat(" invoiceDate >= '" + sqlStart +"' AND invoiceDate <= '" + sqlEnd +"'");
        
            switch (sortChoice1.getSelectedIndex()) {
                case 0:
                    sortBy = "'invoiceDate';";
                    break;
                case 1:
                    sortBy = "invoiceType';";
                    break;
                default:
                    sortBy = "invoiceTotal;";
                    break;
            }
       
        search = search.concat(" ORDER BY " + sortBy);
        
        
        
          stmt = "INSERT INTO financedb.journal (entryDate,entryType,entryStmt) VALUES (?,?,?);" ;
           pst = con.prepareStatement(stmt);
           
        pst.setDate(1, date);
        pst.setString(2,"Accounts Payable");
        pst.setString(3,search);
        pst.executeUpdate();
   
           showJournals();
           JOptionPane.showMessageDialog(null, "The journal entry has been created.");
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "An error has occured. Unable to generate report.");
            System.out.println(e.getMessage());
        }finally {
    try { pst.close(); } catch (Exception ex) { System.out.println(ex.getMessage()); }
    try { con.close(); } catch (Exception ex1) { System.out.println(ex1.getMessage()); }
}
        
        
        
        
        
        //WHERE CONCAT(`invoiceId`, `fname`, `lname`, `age`) LIKE '%"+tags+"%'"
       
        //model.addRow(Object[] date,'Credit');
        
    }//GEN-LAST:event_apButtonActionPerformed

    private void arButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arButtonActionPerformed
        

        DefaultTableModel model2 = (DefaultTableModel)jTable2.getModel();
        SimpleDateFormat formatter =  new SimpleDateFormat("yyyy-MM-dd");
       
        
        
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
       // Date myDate = format.parse(date);
      //  java.sql.Date sqlDate = new java.sql.Date(myDate);
        
        Connection con = null;
        PreparedStatement pst = null;
       ResultSet rs = null;
        
        
        try{
             Date start =  formatter.parse(formatter.format(arStartDate.getDate()));
             Date end =  formatter.parse(formatter.format(arEndDate.getDate()));
             java.sql.Date sqlStart = new java.sql.Date(start.getTime());
             java.sql.Date sqlEnd = new java.sql.Date(end.getTime());
           con = DriverManager.getConnection("jdbc:mysql://fetch-mobile-grooming.mysql.database.azure.com/Fetchdb","malderson@fetch-mobile-grooming","Puppy123");
           String stmt;
           String search = "SELECT * FROM financedb.invoice  WHERE (";
           String sortBy ;
           
           
           if(checkbox6.getState()){  
               search  = search.concat(" invoiceSource = 'Sale' ");
           }
           if(checkbox7.getState()){
              search = search.concat("OR invoiceSource = 'Endorsement' ");
           }
           if(checkbox8.getState()){
               search = search.concat("OR invoiceSource = 'Grant' ");
           }
           if(checkbox9.getState()){
               search = search.concat("OR invoiceSource = 'Payment/Royalty' ");
           }
        
           search = search.concat(") AND ");
        
          search = search.concat(" invoiceDate >= '" + sqlStart +"' AND invoiceDate <= '" + sqlEnd +"'");
        
            switch (sortChoice2.getSelectedIndex()) {
                case 0:
                    sortBy = "invoiceDate;";
                    break;
                case 1:
                    sortBy = "invoiceType;";
                    break;
                default:
                    sortBy = "invoiceTotal;";
                    break;
            }
       
        search = search.concat(" ORDER BY " + sortBy);
        
        
        
          stmt = "INSERT INTO financedb.journal (entryDate,entryType,entryStmt) VALUES (?,?,?);" ;
           pst = con.prepareStatement(stmt);
           
        pst.setDate(1, date);
        pst.setString(2,"Accounts Receivable");
        pst.setString(3,search);
        pst.executeUpdate();
       
            showJournals();
           JOptionPane.showMessageDialog(null, "The journal entry has been created.");
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "An error has occured. Unable to generate report.");
            System.out.println(e.getMessage());
        }finally {
    try { pst.close(); } catch (Exception e) { /* ignored */ }
    try { con.close(); } catch (Exception e) { /* ignored */ }
}
        
        
         
    }//GEN-LAST:event_arButtonActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
         
        
        DefaultTableModel model2 = (DefaultTableModel)jTable2.getModel();
        SimpleDateFormat formatter =  new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        
        Connection con = null;
       ResultSet rs = null;
       PreparedStatement pst1 = null;
        try{
             Date start =  formatter.parse(formatter.format(arStartDate.getDate()));
             Date end =  formatter.parse(formatter.format(arEndDate.getDate()));
             java.sql.Date sqlStart = new java.sql.Date(start.getTime());
             java.sql.Date sqlEnd = new java.sql.Date(end.getTime());
           con = DriverManager.getConnection("jdbc:mysql://fetch-mobile-grooming.mysql.database.azure.com/Fetchdb","malderson@fetch-mobile-grooming","Puppy123");
           String stmt;
           Statement st1 = null;
           String search = "SELECT * FROM financedb.invoice  WHERE (";
           String sortBy ;
           
        
          search = search.concat(" invoiceDate >= '" + sqlStart +"' AND invoiceDate <= '" + sqlEnd +"'");
        
            switch (sortChoice2.getSelectedIndex()) {
                case 0:
                    sortBy = "invoiceDate;";
                    break;
                case 1:
                    sortBy = "invoiceType;";
                    break;
                default:
                    sortBy = "invoiceTotal;";
                    break;
            }
       
        search = search.concat(" ORDER BY " + sortBy);
        
        
        
          stmt = "INSERT INTO financedb.journal (entryDate,entryType,entryStmt) VALUES (?,?,?);" ;
           pst1 = con.prepareStatement(stmt);
           
        pst1.setDate(1, date);
        pst1.setString(2,"General Ledger");
        pst1.setString(3,search);
        pst1.executeUpdate();
           
           
              
            
            showJournals();
           JOptionPane.showMessageDialog(null, "The journal entry has been created.");
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "An error has occured. Unable to generate report.");
            System.out.println(e.getMessage());
        }finally {
    try { rs.close(); } catch (Exception e) { /* ignored */ }
    try { pst1.close(); } catch (Exception e) { /* ignored */ }
    try { con.close(); } catch (Exception e) { /* ignored */ }
    }//GEN-LAST:event_button2ActionPerformed

    }
    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
       //JOURNAL DELETE BUTTON
        
        DefaultTableModel model2 = (DefaultTableModel)jTable2.getModel();
        int selected = jTable2.getSelectedRow();
        if(jTable2.getSelectedRowCount()>0){
            model2.removeRow(selected);
        }
    }//GEN-LAST:event_button3ActionPerformed

    private void yearChoice1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_yearChoice1ItemStateChanged
        // TODO add your handling code here:
        
        String stDate,endDate;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        stDate = (yearChoice1.getSelectedItem() + "-01-01");
        endDate = (yearChoice1.getSelectedItem() + "-12-31");
        
        try{
             apStartDate.setDate(formatter.parse(stDate));
             apEndDate.setDate(formatter.parse(endDate));
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "An error has occured. Unable to generate report.");
            System.out.println(e.getMessage());
        }
       
       
    }//GEN-LAST:event_yearChoice1ItemStateChanged

    private void choice4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choice4ItemStateChanged
        // TODO add your handling code here:
        String stDate,endDate;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        stDate = (choice4.getSelectedItem() + "-01-01");
        endDate = (choice4.getSelectedItem() + "-12-31");
        
        try{
             arStartDate.setDate(formatter.parse(stDate));
             arEndDate.setDate(formatter.parse(endDate));
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "An error has occured. Unable to generate report.");
             System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_choice4ItemStateChanged

    private void choice4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_choice4FocusLost
        // TODO add your handling code here:
       String stDate,endDate;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        stDate = (choice4.getSelectedItem() + "-01-01");
        endDate = (choice4.getSelectedItem() + "-12-31");
        
        try{
             arStartDate.setDate(formatter.parse(stDate));
             arEndDate.setDate(formatter.parse(endDate));
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "An error has occured. Unable to generate report.");
             System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_choice4FocusLost

    private void yearChoice3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_yearChoice3ItemStateChanged
        // TODO add your handling code here:
        String stDate,endDate;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        stDate = (yearChoice3.getSelectedItem() + "-01-01");
        endDate = (yearChoice3.getSelectedItem() + "-12-31");
        
        try{
             jXDatePicker1.setDate(formatter.parse(stDate));
             jXDatePicker2.setDate(formatter.parse(endDate));
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "An error has occured. Unable to generate report.");
             System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_yearChoice3ItemStateChanged

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        // TODO add your handling code here:
        int selectRow;
        int id = 0;
        Statement stmt = null;
        DefaultTableModel table = new DefaultTableModel();
        DecimalFormat twoDigits = new DecimalFormat("$#,###.00");
        ResultSet rs = null;
        ResultSet rs2 = null;
        Connection con = null;
        Object[] row = new Object[6];
        String sql = "";
        if(jTable2.getSelectedRow()>-1){
            try{
               selectRow = jTable2.getSelectedRow();
               id = (int) jTable2.getValueAt(selectRow,0);
               
           con = DriverManager.getConnection("jdbc:mysql://fetch-mobile-grooming.mysql.database.azure.com/Fetchdb","malderson@fetch-mobile-grooming","Puppy123");
           String search = "SELECT entryStmt FROM financedb.journal  WHERE entryId = '" + id + "';";
           
           
           table.setColumnIdentifiers(new Object[]{"Invoice ID","Invoice Date","Invoice Type", "Invoice Total","Invoice Source","Invoice Tags"});
           stmt = con.createStatement();
            rs = stmt.executeQuery(search);
            while(rs.next()){
             sql = rs.getString("entryStmt");
           }
            stmt = con.createStatement();
            rs2 = stmt.executeQuery(sql);
            
            while (rs2.next()){
            row[0] = rs2.getInt("invoiceId");
            row[1] = rs2.getDate("invoiceDate");
            row[2] = rs2.getString("invoiceType");
            row[3] = twoDigits.format(rs2.getDouble("invoiceTotal"));
            row[4] = rs2.getString("invoicesource");
            row[5] = rs2.getString("invoiceTags");
            table.addRow(row);
            }
            JTable table1 = new JTable();
            table1.setModel(table);
            JOptionPane.showMessageDialog(null, new JScrollPane(table1));
            }catch(Exception e){
                System.out.println(e.getMessage() + "id = " + id);
            }finally{
                try { rs.close(); } catch (Exception e) { /* ignored */ }
                try { rs2.close(); } catch (Exception e) { /* ignored */ }
                try { con.close(); } catch (Exception e) { /* ignored */ }
            }
        }
    }//GEN-LAST:event_button5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(financeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(financeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(financeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(financeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new financeJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button apButton;
    private org.jdesktop.swingx.JXDatePicker apEndDate;
    private org.jdesktop.swingx.JXDatePicker apStartDate;
    private java.awt.Button arButton;
    private org.jdesktop.swingx.JXDatePicker arEndDate;
    private org.jdesktop.swingx.JXDatePicker arStartDate;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button5;
    private javax.swing.ButtonGroup buttonGroup1;
    private java.awt.Checkbox checkbox1;
    private java.awt.Checkbox checkbox2;
    private java.awt.Checkbox checkbox3;
    private java.awt.Checkbox checkbox4;
    private java.awt.Checkbox checkbox5;
    private java.awt.Checkbox checkbox6;
    private java.awt.Checkbox checkbox7;
    private java.awt.Checkbox checkbox8;
    private java.awt.Checkbox checkbox9;
    private java.awt.Choice choice1;
    private java.awt.Choice choice3;
    private java.awt.Choice choice4;
    private javax.swing.JTextField invAmntTextField;
    private org.jdesktop.swingx.JXDatePicker invDate;
    private java.awt.Choice invSourceChoice;
    private javax.swing.JTextField invTagTextField;
    private java.awt.Choice invTypeChoice;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    private java.awt.Label label1;
    private java.awt.Label label11;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private javax.swing.JLabel madeInvoiceLabel;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.Menu menu5;
    private java.awt.Menu menu6;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private java.awt.MenuBar menuBar3;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private java.awt.Choice sortChoice1;
    private java.awt.Choice sortChoice2;
    private java.awt.Choice sortChoice3;
    private java.awt.Choice yearChoice1;
    private java.awt.Choice yearChoice3;
    // End of variables declaration//GEN-END:variables
}
