using System;
using System.Data;
using System.Drawing;
using System.Windows.Forms;
using MySql.Data.MySqlClient;

namespace BetaalSysteem
{
    public partial class Bestellen : Form
    {
        MySqlConnection conn;
        MySqlCommand cmd;
        private string connectionstring = "Server=127.0.0.1; Database=GDOS;Uid=root;Pwd=";

        public Bestellen()
        {
            InitializeComponent();
        }

        private void Bestellen_Load(object sender, EventArgs e)
        {
            try
            {
                BackColor = Color.Gray;
                lblBedrijfNaam.Size = new Size(900, 150);
                FormBorderStyle = FormBorderStyle.None;
                WindowState = FormWindowState.Maximized;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                Form form2 = new Kassa();

                form2.Show();
                this.Hide();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            try
            {
                String Tafel = comboBox1.SelectedItem.ToString();

                conn = new MySqlConnection(connectionstring);
                conn.Open();
                string query = $"SELECT ID, TableNumber, ProductID, ProductName, Quantity, DateTime, Paid FROM bestellingen WHERE TableNumber='{Tafel}' ORDER BY DateTime DESC";

                using (MySqlDataAdapter adapter = new MySqlDataAdapter(query, conn))
                {
                    DataSet ds = new DataSet();
                    adapter.Fill(ds);
                    Bonnetjes.DataSource = ds.Tables[0];

                    Bonnetjes.Columns["ID"].MinimumWidth = 50;
                    Bonnetjes.Columns["TableNumber"].MinimumWidth = 250;
                    Bonnetjes.Columns["ProductID"].MinimumWidth = 50;
                    Bonnetjes.Columns["ProductName"].MinimumWidth = 250;
                    Bonnetjes.Columns["Quantity"].MinimumWidth = 50;
                    Bonnetjes.Columns["DateTime"].MinimumWidth = 250;
                    Bonnetjes.Columns["Paid"].MinimumWidth = 50;
                }

                conn.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error " + ex.Message);
            }
        }
    }
}
