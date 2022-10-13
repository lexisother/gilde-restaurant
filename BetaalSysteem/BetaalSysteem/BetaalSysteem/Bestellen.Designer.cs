namespace BetaalSysteem
{
    partial class Bestellen
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.lblBedrijfNaam = new System.Windows.Forms.Label();
            this.btnBeheer = new System.Windows.Forms.Button();
            this.btnBetaal = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.comboBox1 = new System.Windows.Forms.ComboBox();
            this.Bonnetjes = new System.Windows.Forms.DataGridView();
            ((System.ComponentModel.ISupportInitialize)(this.Bonnetjes)).BeginInit();
            this.SuspendLayout();
            // 
            // lblBedrijfNaam
            // 
            this.lblBedrijfNaam.AutoSize = true;
            this.lblBedrijfNaam.Font = new System.Drawing.Font("Microsoft Sans Serif", 30F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblBedrijfNaam.ForeColor = System.Drawing.SystemColors.ButtonFace;
            this.lblBedrijfNaam.Location = new System.Drawing.Point(12, 9);
            this.lblBedrijfNaam.Name = "lblBedrijfNaam";
            this.lblBedrijfNaam.Size = new System.Drawing.Size(574, 46);
            this.lblBedrijfNaam.TabIndex = 0;
            this.lblBedrijfNaam.Text = "Holly Guacamoley Bestellingen";
            // 
            // btnBeheer
            // 
            this.btnBeheer.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.btnBeheer.Location = new System.Drawing.Point(1070, 98);
            this.btnBeheer.Name = "btnBeheer";
            this.btnBeheer.Size = new System.Drawing.Size(192, 72);
            this.btnBeheer.TabIndex = 4;
            this.btnBeheer.Text = "Beheer";
            this.btnBeheer.UseVisualStyleBackColor = true;
            // 
            // btnBetaal
            // 
            this.btnBetaal.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.btnBetaal.Location = new System.Drawing.Point(1070, 569);
            this.btnBetaal.Name = "btnBetaal";
            this.btnBetaal.Size = new System.Drawing.Size(192, 72);
            this.btnBetaal.TabIndex = 7;
            this.btnBetaal.Text = "Betaal";
            this.btnBetaal.UseVisualStyleBackColor = true;
            // 
            // button1
            // 
            this.button1.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.button1.Location = new System.Drawing.Point(1070, 176);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(192, 72);
            this.button1.TabIndex = 10;
            this.button1.Text = "Kassa";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // comboBox1
            // 
            this.comboBox1.FormattingEnabled = true;
            this.comboBox1.Items.AddRange(new object[] {
            "Tafel 1",
            "Tafel 2",
            "Tafel 3",
            "Tafel 4",
            "Tafel 5",
            "Tafel 6",
            "Tafel 7",
            "Tafel 8",
            "Tafel 9",
            "Tafel 10",
            "Tafel 11",
            "Tafel 12"});
            this.comboBox1.Location = new System.Drawing.Point(20, 71);
            this.comboBox1.Name = "comboBox1";
            this.comboBox1.Size = new System.Drawing.Size(145, 21);
            this.comboBox1.TabIndex = 11;
            this.comboBox1.SelectedIndexChanged += new System.EventHandler(this.comboBox1_SelectedIndexChanged);
            // 
            // Bonnetjes
            // 
            this.Bonnetjes.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
            | System.Windows.Forms.AnchorStyles.Left)
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Bonnetjes.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.Bonnetjes.Location = new System.Drawing.Point(20, 99);
            this.Bonnetjes.Name = "Bonnetjes";
            this.Bonnetjes.RowHeadersWidth = 108;
            this.Bonnetjes.Size = new System.Drawing.Size(1044, 542);
            this.Bonnetjes.TabIndex = 12;
            // 
            // Bestellingen
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Gray;
            this.ClientSize = new System.Drawing.Size(1274, 653);
            this.Controls.Add(this.Bonnetjes);
            this.Controls.Add(this.comboBox1);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.btnBetaal);
            this.Controls.Add(this.btnBeheer);
            this.Controls.Add(this.lblBedrijfNaam);
            this.Name = "Bestellingen";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Bestellen_Load);
            ((System.ComponentModel.ISupportInitialize)(this.Bonnetjes)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblBedrijfNaam;
        private System.Windows.Forms.Button btnBeheer;
        private System.Windows.Forms.Button btnBetaal;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.ComboBox comboBox1;
        private System.Windows.Forms.DataGridView Bonnetjes;
    }
}

