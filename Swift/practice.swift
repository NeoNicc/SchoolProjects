//initial struct for a survey vote on which grocery store is best
struct FaveGroceryStore {
    let personNum: Int

    enum Stores {
        case walmart
        case aldi
        case publix
    }
    //the participant's instance has a random store from the Stores enum as its favorite store value
    var faveStore: Stores {
        return Stores.allCases.randomElement()  
    }
}

//struct for individual instances of a bar graph made from the results of specific numbers of survey participants
struct BarChartForSurvey {
    var faveStores: [FaveGroceryStore] = []
    var walmartVotes = 0
    var aldiVotes = 0
    var publixVotes = 0
    //calculates votes for each grocery store for a chosen number of survey results 
    mutating func surveyResults(of number: Int) {
        for i in 1...number {
            faveStores.append(FaveGroceryStore(i))
        }
        for vote in faveStore {
            switch(vote.faveStore) {
                case .walmart:
                walmartVotes += 1
                case .aldi:
                aldiVotes += 1
                case .publix:
                publixVotes += 1
            }
        }
    }
    //displays a bar graph with this instance of the survey as its data
    func showBarGraph() {
        //create graph
        //create graph title "Votes by Store"
        //add bars and labels
        //add a key
        //generate graph
    }
}