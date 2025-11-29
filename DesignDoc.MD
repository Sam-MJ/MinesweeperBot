# Online Minesweeper Bot

## BoardInteractions performs all browser automation and uses a page object model so that it can be adjusted to any website.
- setup
    - load page, accept cookies etc
- get board to return to solver
- take turns

## Turn solver
- find any guaranteed mines
- find any guaranteed safe spots
- if no guaranteed actions:
    -random for now



// Should concrete base page be init at app level or inside boardinteractions?
// maybe POM should be the only place with a webdriver.
// don't forget to close driver at the end.

Sites:
    BasePage - defines all of the basic interactions that are needed by a page
    POM - contains all of the specific properties and interactions with the page. along with actions that require that behaviour.
GameController - performs actions to setup the game and interact with POM interactions into behaviour
Board interactions - interface between the POM Controller and the internal board game state
Board - object to hold the internal game state
