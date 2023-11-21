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
        switch (articleCategoryNum){
            case 1:
                articleOne = new ArticleImageContainer(new Image("news.png"), "General News Release", "Nov 4, 2023", "Resources/ArticleImages/NewsArticles/Nov4News");
                articleOneContainer = articleOne.setContainerBehavior();
                articleTwo = new ArticleImageContainer(new Image("Q3.png"), "Third Quarter News Release", "Nov 2, 2023", "Resources/ArticleImages/NewsArticles/Nov2News");
                articleTwoContainer = articleTwo.setContainerBehavior();
                articleThree  = new ArticleImageContainer(new Image("news.png"), "General News Release", "Aug 5, 2023", "Resources/ArticleImages/NewsArticles/Aug5News");
                articleThreeContainer = articleThree.setContainerBehavior();
                articleFour = new ArticleImageContainer(new Image("Q2.png"), "Second Quarter News Release", "Aug 3, 2023", "Resources/ArticleImages/NewsArticles/Aug3News");
                articleFourContainer = articleFour.setContainerBehavior();
                articleSectionPane.add(articleOneContainer, 0, 0);
                articleSectionPane.add(articleTwoContainer, 1,0);
                articleSectionPane.add(articleThreeContainer, 0,1);
                articleSectionPane.add(articleFourContainer, 1,1);
                break;
            case 2:
                articleOne = new ArticleImageContainer(new Image("news.png"), "First sustainability", "Nov 4, 2023", "Resources/ArticleImages/NewsArticles/Nov4News");
                articleOneContainer = articleOne.setContainerBehavior();
                articleTwo = new ArticleImageContainer(new Image("news.png"), "Second sustainability", "Nov 2, 2023", "Resources/ArticleImages/NewsArticles/Nov2News");
                articleTwoContainer = articleTwo.setContainerBehavior();
                articleThree  = new ArticleImageContainer(new Image("news.png"), "General News Release", "Aug 5, 2023", "Resources/ArticleImages/NewsArticles/Aug5News");
                articleThreeContainer = articleThree.setContainerBehavior();
                articleFour = new ArticleImageContainer(new Image("news.png"), "Second Quarter News Release", "Aug 3, 2023", "Resources/ArticleImages/NewsArticles/Aug3News");
                articleFourContainer = articleFour.setContainerBehavior();
                articleSectionPane.add(articleOneContainer, 0, 0);
                articleSectionPane.add(articleTwoContainer, 1,0);
                articleSectionPane.add(articleThreeContainer, 0,1);
                articleSectionPane.add(articleFourContainer, 1,1);
                break;
            case 3:
                articleOne = new ArticleImageContainer(new Image("Q3.png"), "Third Quarter Report", "Sep 20 2023", "Resources/ArticleImages/MeetingReportArticles/ThirdQuarterReport");
                articleOneContainer = articleOne.setContainerBehavior();
                articleTwo = new ArticleImageContainer(new Image("Q2.png"), "Second Quarter Report", "June 30, 2023", "Resources/ArticleImages/MeetingReportArticles/SecondQuarterReport");
                articleTwoContainer = articleTwo.setContainerBehavior();
                articleThree  = new ArticleImageContainer(new Image("Q1.png"), "FirstQuarterReport", "March 31, 2023", "Resources/ArticleImages/MeetingReportArticles/FirstQuarterReport");
                articleThreeContainer = articleThree.setContainerBehavior();
                articleFour = new ArticleImageContainer(new Image("Q4.png"), "Annual Report", "2022", "Resources/ArticleImages/MeetingReportArticles/AnnualReport");
                articleFourContainer = articleFour.setContainerBehavior();
                articleSectionPane.add(articleOneContainer, 0, 0);
                articleSectionPane.add(articleTwoContainer, 1,0);
                articleSectionPane.add(articleThreeContainer, 0,1);
                articleSectionPane.add(articleFourContainer, 1,1);
                break;
            case 4:
                articleOne = new ArticleImageContainer(new Image("news.png"), "Comparative Rights", "June 20, 2010", "Resources/ArticleImages/StockHolderArticles/ComparativeRights");
                articleOneContainer = articleOne.setContainerBehavior();
                articleTwo = new ArticleImageContainer(new Image("news.png"), "Energy Presentation", "Nov 2022", "Resources/ArticleImages/StockHolderArticles/EnergyPresentation");
                articleTwoContainer = articleTwo.setContainerBehavior();
                articleThree  = new ArticleImageContainer(new Image("news.png"), "Investment Information", "Feb 17, 2022", "Resources/ArticleImages/StockHolderArticles/InvestmentFacts");
                articleThreeContainer = articleThree.setContainerBehavior();
                articleFour = new ArticleImageContainer(new Image("news.png"), "Stock Holder Info", "2022", "Resources/ArticleImages/StockHolderArticles/StockHolderInfo");
                articleFourContainer = articleFour.setContainerBehavior();
                articleSectionPane.add(articleOneContainer, 0, 0);
                articleSectionPane.add(articleTwoContainer, 1,0);
                articleSectionPane.add(articleThreeContainer, 0,1);
                articleSectionPane.add(articleFourContainer, 1,1);
                break;
        }
    }


}
