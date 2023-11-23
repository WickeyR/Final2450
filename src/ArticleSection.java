//Author: Ricky Franco
//15 Nov 2023
//ArticleSection.java: 

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class ArticleSection extends GridPane {

    int articleCategoryNum;
    GridPane articleSectionPane;

    public ArticleSection(int articleCategoryNum){
        this.articleCategoryNum = articleCategoryNum;
        this.articleSectionPane = new GridPane();
        setArticles();
        setGridPaneStyling();
    }

    public GridPane getGridPane(){
        return articleSectionPane;
    }

    public void setGridPaneStyling(){
        articleSectionPane.setVgap(20);
        articleSectionPane.setHgap(20);

    }

    public void setArticles(){
        // Initialize the containers first so that they can be set
        // Add all other cases-and actions
        ArticleImageContainer articleOne, articleTwo, articleThree, articleFour;
        HBox articleOneContainer, articleTwoContainer, articleThreeContainer, articleFourContainer;
        switch (articleCategoryNum) {
            case 1 -> {
                articleOne = new ArticleImageContainer(new Image("ArticleThumbnails/news.png"), "General News Release", "Nov 4, 2023", "src/PdfPaths/News Reports/nov0423.pdf");
                articleOneContainer = articleOne.setContainerBehavior();
                articleTwo = new ArticleImageContainer(new Image("ArticleThumbnails/Q3.png"), "Third Quarter News Release", "Nov 2, 2023", "src/PdfPaths/News Reports/nov0223.pdf");
                articleTwoContainer = articleTwo.setContainerBehavior();
                articleThree = new ArticleImageContainer(new Image("ArticleThumbnails/news.png"), "General News Release", "Aug 5, 2023", "src/PdfPaths/News Reports/aug0523.pdf");
                articleThreeContainer = articleThree.setContainerBehavior();
                articleFour = new ArticleImageContainer(new Image("ArticleThumbnails/Q2.png"), "Second Quarter News Release", "Aug 3, 2023", "src/PdfPaths/News Reports/aug0323.pdf");
                articleFourContainer = articleFour.setContainerBehavior();
                articleSectionPane.add(articleOneContainer, 0, 0);
                articleSectionPane.add(articleTwoContainer, 1, 0);
                articleSectionPane.add(articleThreeContainer, 0, 1);
                articleSectionPane.add(articleFourContainer, 1, 1);
            }
            case 2 -> {
                articleOne = new ArticleImageContainer(new Image("ArticleThumbnails/news.png"), "Berkshire Hathaway Diversity", "2021", "src/PdfPaths/Sustainability/berkshire2021eeo1.pdf");
                articleOneContainer = articleOne.setContainerBehavior();
                articleTwo = new ArticleImageContainer(new Image("ArticleThumbnails/news.png"), "Leadership Council", "2021", "src/PdfPaths/Sustainability/brksustainabilityleadershipcouncilmay2021.pdf");
                articleTwoContainer = articleTwo.setContainerBehavior();
                articleThree = new ArticleImageContainer(new Image("ArticleThumbnails/news.png"), "PACIFICORP Information", "2023", "src/PdfPaths/Sustainability/facts_pacificorp.pdf");
                articleThreeContainer = articleThree.setContainerBehavior();
                articleFour = new ArticleImageContainer(new Image("ArticleThumbnails/news.png"), "Mid American Energy Information", "2023", "src/PdfPaths/Sustainability/facts_midamerican_energy_company.pdf");
                articleFourContainer = articleFour.setContainerBehavior();
                articleSectionPane.add(articleOneContainer, 0, 0);
                articleSectionPane.add(articleTwoContainer, 1, 0);
                articleSectionPane.add(articleThreeContainer, 0, 1);
                articleSectionPane.add(articleFourContainer, 1, 1);
            }
            case 3 -> {
                articleOne = new ArticleImageContainer(new Image("ArticleThumbnails/Q3.png"), "Third Quarter Report", "Sep 20 2023", "src/PdfPaths/QuarterReports/3rdqtr23.pdf");
                articleOneContainer = articleOne.setContainerBehavior();
                articleTwo = new ArticleImageContainer(new Image("ArticleThumbnails/Q2.png"), "Second Quarter Report", "June 30, 2023", "src/PdfPaths/QuarterReports/2ndqtr23.pdf");
                articleTwoContainer = articleTwo.setContainerBehavior();
                articleThree = new ArticleImageContainer(new Image("ArticleThumbnails/Q1.png"), "FirstQuarterReport", "March 31, 2023", "src/PdfPaths/QuarterReports/1stqtr23.pdf");
                articleThreeContainer = articleThree.setContainerBehavior();
                articleFour = new ArticleImageContainer(new Image("ArticleThumbnails/Q4.png"), "Annual Report", "2022", "src/PdfPaths/QuarterReports/2022ar.pdf");
                articleFourContainer = articleFour.setContainerBehavior();
                articleSectionPane.add(articleOneContainer, 0, 0);
                articleSectionPane.add(articleTwoContainer, 1, 0);
                articleSectionPane.add(articleThreeContainer, 0, 1);
                articleSectionPane.add(articleFourContainer, 1, 1);
            }
            case 4 -> {
                articleOne = new ArticleImageContainer(new Image("ArticleThumbnails/news.png"), "Comparative Rights", "June 20, 2010", "src/PdfPaths/StockHolderArticles/comparativeRights.pdf");
                articleOneContainer = articleOne.setContainerBehavior();
                articleTwo = new ArticleImageContainer(new Image("ArticleThumbnails/news.png"), "Energy Presentation", "Nov 2022", "src/PdfPaths/StockHolderArticles/BHE2022InvestPresent.pdf");
                articleTwoContainer = articleTwo.setContainerBehavior();
                articleThree = new ArticleImageContainer(new Image("ArticleThumbnails/news.png"), "Investment Information", "Feb 17, 2022", "src/PdfPaths/StockHolderArticles/FactsAboutInvesting.pdf");
                articleThreeContainer = articleThree.setContainerBehavior();
                articleFour = new ArticleImageContainer(new Image("ArticleThumbnails/news.png"), "Stock Holder Info", "2022", "src/PdfPaths/StockHolderArticles/commonStock.pdf");
                articleFourContainer = articleFour.setContainerBehavior();
                articleSectionPane.add(articleOneContainer, 0, 0);
                articleSectionPane.add(articleTwoContainer, 1, 0);
                articleSectionPane.add(articleThreeContainer, 0, 1);
                articleSectionPane.add(articleFourContainer, 1, 1);
            }
        }
    }


}
