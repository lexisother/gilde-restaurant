namespace BetaalSysteem
{
    partial class Form1
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
            this.btnSpaans = new System.Windows.Forms.Button();
            this.btnVega = new System.Windows.Forms.Button();
            this.btnDranken = new System.Windows.Forms.Button();
            this.btnBeheer = new System.Windows.Forms.Button();
            this.btnUitloggen = new System.Windows.Forms.Button();
            this.btnPrintBon = new System.Windows.Forms.Button();
            this.btnBetaal = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // lblBedrijfNaam
            // 
            this.lblBedrijfNaam.AutoSize = true;
            this.lblBedrijfNaam.Font = new System.Drawing.Font("Microsoft Sans Serif", 30F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblBedrijfNaam.ForeColor = System.Drawing.SystemColors.ButtonFace;
            this.lblBedrijfNaam.Location = new System.Drawing.Point(12, 9);
            this.lblBedrijfNaam.Name = "lblBedrijfNaam";
            this.lblBedrijfNaam.Size = new System.Drawing.Size(346, 46);
            this.lblBedrijfNaam.TabIndex = 0;
            this.lblBedrijfNaam.Text = "Holly Guacamoley";
            // 
            // btnSpaans
            // 
            this.btnSpaans.Location = new System.Drawing.Point(384, 20);
            this.btnSpaans.Name = "btnSpaans";
            this.btnSpaans.Size = new System.Drawing.Size(181, 69);
            this.btnSpaans.TabIndex = 1;
            this.btnSpaans.Text = "Spaans";
            this.btnSpaans.UseVisualStyleBackColor = true;
            // 
            // btnVega
            // 
            this.btnVega.Location = new System.Drawing.Point(571, 20);
            this.btnVega.Name = "btnVega";
            this.btnVega.Size = new System.Drawing.Size(168, 69);
            this.btnVega.TabIndex = 2;
            this.btnVega.Text = "Vega";
            this.btnVega.UseVisualStyleBackColor = true;
            // 
            // btnDranken
            // 
            this.btnDranken.Location = new System.Drawing.Point(745, 20);
            this.btnDranken.Name = "btnDranken";
            this.btnDranken.Size = new System.Drawing.Size(164, 69);
            this.btnDranken.TabIndex = 3;
            this.btnDranken.Text = "Dranken";
            this.btnDranken.UseVisualStyleBackColor = true;
            // 
            // btnBeheer
            // 
            this.btnBeheer.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.btnBeheer.Location = new System.Drawing.Point(1070, 71);
            this.btnBeheer.Name = "btnBeheer";
            this.btnBeheer.Size = new System.Drawing.Size(192, 80);
            this.btnBeheer.TabIndex = 4;
            this.btnBeheer.Text = "Beheer";
            this.btnBeheer.UseVisualStyleBackColor = true;
            // 
            // btnUitloggen
            // 
            this.btnUitloggen.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.btnUitloggen.Location = new System.Drawing.Point(1070, 182);
            this.btnUitloggen.Name = "btnUitloggen";
            this.btnUitloggen.Size = new System.Drawing.Size(192, 72);
            this.btnUitloggen.TabIndex = 5;
            this.btnUitloggen.Text = "Uitloggen";
            this.btnUitloggen.UseVisualStyleBackColor = true;
            // 
            // btnPrintBon
            // 
            this.btnPrintBon.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.btnPrintBon.Location = new System.Drawing.Point(1070, 260);
            this.btnPrintBon.Name = "btnPrintBon";
            this.btnPrintBon.Size = new System.Drawing.Size(192, 72);
            this.btnPrintBon.TabIndex = 6;
            this.btnPrintBon.Text = "Print laatste bon";
            this.btnPrintBon.UseVisualStyleBackColor = true;
            // 
            // btnBetaal
            // 
            this.btnBetaal.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.btnBetaal.Location = new System.Drawing.Point(1070, 338);
            this.btnBetaal.Name = "btnBetaal";
            this.btnBetaal.Size = new System.Drawing.Size(192, 76);
            this.btnBetaal.TabIndex = 7;
            this.btnBetaal.Text = "Betaal";
            this.btnBetaal.UseVisualStyleBackColor = true;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Gray;
            this.ClientSize = new System.Drawing.Size(1274, 653);
            this.Controls.Add(this.btnBetaal);
            this.Controls.Add(this.btnPrintBon);
            this.Controls.Add(this.btnUitloggen);
            this.Controls.Add(this.btnBeheer);
            this.Controls.Add(this.btnDranken);
            this.Controls.Add(this.btnVega);
            this.Controls.Add(this.btnSpaans);
            this.Controls.Add(this.lblBedrijfNaam);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblBedrijfNaam;
        private System.Windows.Forms.Button btnSpaans;
        private System.Windows.Forms.Button btnVega;
        private System.Windows.Forms.Button btnDranken;
        private System.Windows.Forms.Button btnBeheer;
        private System.Windows.Forms.Button btnUitloggen;
        private System.Windows.Forms.Button btnPrintBon;
        private System.Windows.Forms.Button btnBetaal;
    }
}

