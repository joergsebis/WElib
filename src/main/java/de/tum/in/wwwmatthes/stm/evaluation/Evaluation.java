package de.tum.in.wwwmatthes.stm.evaluation;

import java.util.List;

import de.tum.in.wwwmatthes.stm.models.base.Model;

public class Evaluation {
	
	private DataSet 	dataSet;
	private Model	model;
	
	public Evaluation(DataSet dataSet, Model model) {		
		this.dataSet 	= dataSet;
		this.model 		= model;
	}
	
	public double evaluateWithMRR() {
		double mrr = 0;
		for(DataSetItem item : dataSet.getItems()) {
			List<String> rankedDocuments = model.rankedDocumentsForText(item.getInput());
			mrr += Evaluation.mrr(item.getOutput(), rankedDocuments);
		}
		return mrr / dataSet.getItems().size();
	}

	
	/*
	 * Private Methods
	 */
	
	private static double mrr(List<String> relevantDocuments, List<String> rankedDocuments) {
		double sum = 0;
		for(String relevantDocument : relevantDocuments) {
			sum += 1.0 / (double) (rankedDocuments.indexOf(relevantDocument) + 1.0);
		}
		return sum / relevantDocuments.size();
	}
	
}
