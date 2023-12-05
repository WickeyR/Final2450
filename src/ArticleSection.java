//Author: Ricky Franco, Denise Thuong, Byron Wong
//15 Nov 2023
//ArticleSection.java: Returns the fully formatted Grid Pane that appears as article section

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ArticleSection extends GridPane {

    int articleCategoryNum;

    GridPane articleSectionPane;

    /*
    @PARAM articleCategoryNum: Will determine which values are placed in the article section
    ArticleSection: The constructor that will set the articles and styling based on parameter
     */
    public ArticleSection(int articleCategoryNum){
        this.articleCategoryNum = articleCategoryNum;
        this.articleSectionPane = new GridPane();
        // Calls styling and setting functions to format GridPane
        setArticles();
        setGridPaneStyling();
    }

    //-----------------------------------------GETTER METHODS-----------------------------------------------

    /*
    @Return articleSectionPane: Fully formatted grid pane with contents
    getGridPane: A getter method used by Main.java to place GridPane
     */
    public GridPane getGridPane(){
        return articleSectionPane;
    }

    //-----------------------------------------SETTER METHODS-----------------------------------------------

    /*
    setGridPaneStyling: Sets styling properties of grid-pane for formatting
     */

    public void setGridPaneStyling(){
        articleSectionPane.setVgap(30);
        articleSectionPane.setHgap(30);

    }
    /*
    setArticles: Places all Article contents calling article container in grid-pane. Articles and contents dependent on articleCategoryNum
     */
    public void setArticles(){

        //Each Category contains 4 containers, their contents set based on article Num
        ArticleImageContainer articleOne, articleTwo, articleThree, articleFour;

        //containers are placed in VBox for styling
        VBox articleOneContainer, articleTwoContainer, articleThreeContainer, articleFourContainer;

        //Switch Statement to set contents based on articleCategoryNum
        switch (articleCategoryNum) {
            case 1 -> {
                //In each case, all 4 articles are set to their contents and placed in the GridPane, and their behavior is set
                articleOne = new ArticleImageContainer(new Image("ArticleThumbnails/news.png"), "General News Release", "Nov 4, 2023", "src/PdfPaths/News Reports/nov0423.pdf",
                        "Earnings (losses) of Berkshire Hathaway Inc. and its\n" +
                                  "consolidated subsidiaries for the third quarter and first\n" +
                                " nine months of 2023 and 2022 are summarized below");
                articleOneContainer = articleOne.setContainerBehavior();
                articleTwo = new ArticleImageContainer(new Image("ArticleThumbnails/AnnualReportImgae copy.png"), "Third Quarter News\nRelease", "Nov 2, 2023", "src/PdfPaths/News Reports/nov0223.pdf",
                        "Omaha, NE (BRK.A; BRK.B) – Berkshire Hathaway Inc.’s \n" +
                                "third quarter earnings release and its quarterly report on \n" +
                                "Form 10-Q will be posted on the Internet on Saturday, November 4, 2023");
                articleTwoContainer = articleTwo.setContainerBehavior();
                articleThree = new ArticleImageContainer(new Image("ArticleThumbnails/News2Thumbnail copy.png"), "General News Release", "Aug 5, 2023", "src/PdfPaths/News Reports/aug0523.pdf",
                        "Berkshire’s operating results for the second quarter and \n" +
                                "first six months of 2023 and 2022 are summarized in the\n" +
                                "following paragraphs");
                articleThreeContainer = articleThree.setContainerBehavior();
                articleFour = new ArticleImageContainer(new Image("ArticleThumbnails/Q2.png"), "Second Quarter News\nRelease", "Aug 3, 2023", "src/PdfPaths/News Reports/aug0323.pdf",
                        "Omaha, NE (BRK.A; BRK.B) – Berkshire Hathaway Inc.’s \n" +
                                "second quarter earnings release and its quarterly report on\n" +
                                " Form 10-Q will be posted on the Internet on Saturday,");
                articleFourContainer = articleFour.setContainerBehavior();
                // Each article placed formmated in GridPane
                articleSectionPane.add(articleOneContainer, 0, 0);
                articleSectionPane.add(articleTwoContainer, 1, 0);
                articleSectionPane.add(articleThreeContainer, 0, 1);
                articleSectionPane.add(articleFourContainer, 1, 1);
            }
            case 2 -> {
                articleOne = new ArticleImageContainer(new Image("ArticleThumbnails/DiversityThumnail copy.png"), "Berkshire Hathaway\nDiversity", "2021", "src/PdfPaths/Sustainability/berkshire2021eeo1.pdf",
                        "1. Based on data filed for all Berkshire Hathaway Inc.\n" +
                                " subsidiaries in the 2021 Employer Information Report (EEO-1) \n" +
                                "with the U.S. Equal Employment Opportunity Commission");
                articleOneContainer = articleOne.setContainerBehavior();
                articleTwo = new ArticleImageContainer(new Image("ArticleThumbnails/leadershipCouncil copy.png"), "Leadership Council", "2021", "src/PdfPaths/Sustainability/brksustainabilityleadershipcouncilmay2021.pdf",
                        "The Berkshire Hathaway Sustainability Leadership Council \n" +
                                "(SLC) is an autonomous group of representatives from Berkshire\n"+
                                " Hathaway companies committed to championing the");
                articleTwoContainer = articleTwo.setContainerBehavior();
                articleThree = new ArticleImageContainer(new Image("ArticleThumbnails/Pacificorp copy.png"), "PACIFICORP\nInformation", "2023", "src/PdfPaths/Sustainability/facts_pacificorp.pdf",
                        "PacifiCorp is the largest grid operator in the western U.S., \n" +
                                "serving 2 million customers in six states.");
                articleThreeContainer = articleThree.setContainerBehavior();
                articleFour = new ArticleImageContainer(new Image("ArticleThumbnails/MidAmericanTHumbnail copy.png"), "Mid American\nEnergy Information", "2023", "src/PdfPaths/Sustainability/facts_midamerican_energy_company.pdf",
                        "MidAmerican Energy Company, based in Des Moines, Iowa, meets \n" +
                                "customers’ energy needs by providing safe, reliable, affordable\n" +
                                " and clean energy to customers in Iowa, Illinois, South Dakota and Nebraska.");
                articleFourContainer = articleFour.setContainerBehavior();
                articleSectionPane.add(articleOneContainer, 0, 0);
                articleSectionPane.add(articleTwoContainer, 1, 0);
                articleSectionPane.add(articleThreeContainer, 0, 1);
                articleSectionPane.add(articleFourContainer, 1, 1);
            }
            case 3 -> {
                articleOne = new ArticleImageContainer(new Image("ArticleThumbnails/Q3.png"), "Third Quarter Report", "Sep 20 2023", "src/PdfPaths/QuarterReports/3rdqtr23.pdf", "Information regarding Berkshire Hathaway's \nthird quarterly Report");
                articleOneContainer = articleOne.setContainerBehavior();
                articleTwo = new ArticleImageContainer(new Image("ArticleThumbnails/Q2.png"), "Second Quarter Report", "June 30, 2023", "src/PdfPaths/QuarterReports/2ndqtr23.pdf", "Information regarding Berkshire Hathaway's \nsecond quarterly Report");
                articleTwoContainer = articleTwo.setContainerBehavior();
                articleThree = new ArticleImageContainer(new Image("ArticleThumbnails/Q1.png"), "FirstQuarterReport", "March 31, 2023", "src/PdfPaths/QuarterReports/1stqtr23.pdf", "Information regarding Berkshire Hathaway's \nfirst quarterly Report");
                articleThreeContainer = articleThree.setContainerBehavior();
                articleFour = new ArticleImageContainer(new Image("ArticleThumbnails/Q4.png"), "Annual Report", "2022", "src/PdfPaths/QuarterReports/2022ar.pdf", "Information regarding Berkshire Hathaway's \nannual Report");
                articleFourContainer = articleFour.setContainerBehavior();
                articleSectionPane.add(articleOneContainer, 0, 0);
                articleSectionPane.add(articleTwoContainer, 1, 0);
                articleSectionPane.add(articleThreeContainer, 0, 1);
                articleSectionPane.add(articleFourContainer, 1, 1);
            }
            case 4 -> {
                articleOne = new ArticleImageContainer(new Image("ArticleThumbnails/comparativeRights copy.png"), "Comparative Rights", "June 20, 2010", "src/PdfPaths/StockHolderArticles/comparativeRights.pdf", " Comparative Rights and Relative prices of \nBerkshire Class A and Class B Stock");
                articleOneContainer = articleOne.setContainerBehavior();
                articleTwo = new ArticleImageContainer(new Image("ArticleThumbnails/EnergyPresentationThumbnail copy.png"), "Energy Presentation", "Nov 2022", "src/PdfPaths/StockHolderArticles/BHE2022InvestPresent.pdf", "Presentation shown at EEI annual confernce");
                articleTwoContainer = articleTwo.setContainerBehavior();
                articleThree = new ArticleImageContainer(new Image("ArticleThumbnails/investmentInfo copy.png"), "Investment Information", "Feb 17, 2022", "src/PdfPaths/StockHolderArticles/FactsAboutInvesting.pdf", "Important information for investors of Berkshire Hathaway");
                articleThreeContainer = articleThree.setContainerBehavior();
                articleFour = new ArticleImageContainer(new Image("ArticleThumbnails/StockHolderInfo copy.png"), "Stock Holder\n Info", "2022", "src/PdfPaths/StockHolderArticles/commonStock.pdf", "Stock Holder policies and guidelines related to Berkshire Hathaway");
                articleFourContainer = articleFour.setContainerBehavior();
                articleSectionPane.add(articleOneContainer, 0, 0);
                articleSectionPane.add(articleTwoContainer, 1, 0);
                articleSectionPane.add(articleThreeContainer, 0, 1);
                articleSectionPane.add(articleFourContainer, 1, 1);
            }
        }
    }
}
