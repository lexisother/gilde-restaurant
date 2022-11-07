// {
//   "baseUrl": "https://localhost:7184",
//   "projectId": "6c7c91",
//   "chromeWebSecurity": false,
//   "fixturesFolder": false,
//   "integrationFolder": "cypress/integration",
//   "screenshotsFolder": "cypress/screenshots",
//   "supportFile": "cypress/support/index.js",
//   "videosFolder": "cypress/videos",
//   "numTestsKeptInMemory": 1
// }
module.exports = {
  projectId: '6c7c91',
  chromeWebSecurity: false,
  fixturesFolder: false,
  screenshotsFolder: 'cypress/screenshots',
  videosFolder: 'cypress/videos',
  numTestsKeptInMemory: 1,
  e2e: {
    baseUrl: 'https://localhost:7184',
    chromeWebSecurity: false,
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
  },
};
