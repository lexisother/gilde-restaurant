describe('Homepage', () => {
  it('should load', () => {
    cy.visit('/');
    cy.contains('Welcome back,').should('exist');
  });
});

describe('Products page', () => {
  beforeEach(() => {
    cy.visit('/Products');
  });

  it('should load', () => {
    cy.contains('Product List').should('exist');
  });

  it('should display at least one product', () => {
    cy.contains('created_at').should('exist');
  });

  it('should load product details once a product is clicked', () => {
    cy.get('a[href*="/Products/"]').first().click();
    cy.contains('Product Details').should('exist');
  });

  it('should correctly edit product details', () => {
    cy.get('.pre-content-title').contains('test 1').click();
    cy.contains('Product Details').should('exist');

    // Form is correctly initialized
    cy.get('button.edit-button').click();
    cy.get('input[name="naam"]').should('exist');

    // Change some values
    cy.contains('Naam').parent().next().children('input').click().type('{selectall}test CI');
    cy.contains('Beschrijving')
      .parent()
      .next()
      .children('input')
      .click()
      .type('{selectall}CI desc');
    cy.contains('Prijs').parent().next().children('input').click().type('{selectall}200');
    cy.get('button.edit-button[type="submit"]').click();

    // Wait for the page to load after the button press...
    cy.wait(1000);

    // Check if our new content is here!
    cy.get('.pre-content-title').should('contain', 'test CI');
  });
});
