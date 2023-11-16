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
        ArticleContainer articleOne, articleTwo, articleThree, articleFour;
        HBox articleOneContainer, articleTwoContainer, articleThreeContainer, articleFourContainer;
        switch (articleCategoryNum){
            case 1:
                articleOne = new ArticleContainer(new Image("news.png"), "General News Release", "Nov 4, 2023", "Resources/ArticleImages/NewsArticles/Nov4News");
                articleOneContainer = articleOne.setContainerBehavior();
                articleTwo = new ArticleContainer(new Image("news.png"), "Third Quarter News Release", "Nov 2, 2023", "Resources/ArticleImages/NewsArticles/Nov2News");
                articleTwoContainer = articleTwo.setContainerBehavior();
                articleThree  = new ArticleContainer(new Image("news.png"), "General News Release", "Aug 5, 2023", "Resources/ArticleImages/NewsArticles/Aug5News");
                articleThreeContainer = articleThree.setContainerBehavior();
                articleFour = new ArticleContainer(new Image("news.png"), "Second Quarter News Release", "Aug 3, 2023", "Resources/ArticleImages/NewsArticles/Aug3News");
                articleFourContainer = articleFour.setContainerBehavior();

                articleSectionPane.add(articleOneContainer, 0, 0);
                articleSectionPane.add(articleTwoContainer, 1,0);
                articleSectionPane.add(articleThreeContainer, 0,1);
                articleSectionPane.add(articleFourContainer, 1,1);

        }
    }


}
