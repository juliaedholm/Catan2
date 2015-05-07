/* algorithm that determines the qulaity of a spot based on the learned decision tree */


public class DecisionTree {
	GetSpotFeatures featFinder;
	GraphController graph;
	CatanVertex[] verticesInGraph;
	
	public DecisionTree(GraphController g){
		featFinder = new GetSpotFeatures();
		graph = g;
		verticesInGraph = graph.vertices;
	} 
	
	public boolean isSpotGood (int v){
		boolean debug = false;
		boolean toReturn = false;
		CatanVertex vert = verticesInGraph[v];
		int[] feats = featFinder.getFeaturesForVertex(vert, graph);
		
		//decision tree:
		if (feats[4] == 0){
			if(feats[1] == 0){
				if (debug){
					System.out.println("BAD. Spot had: no 4 (sheep) and no 1(wheat).");
				}
				return false;
			} else if (feats[1] == 1){
				if (feats[0] == 0){
					if (debug){
						System.out.println("BAD. Spot had: no 4 (sheep), yes 1 (wheat), no 0 (rock).");
					}
					return false;
				} else if (feats[0] == 1){
					if (debug){
						System.out.println("GOOD. Spot had: no 4 (sheep), yes 1 (wheat), yes 0 (rock).");
					}
					return true;
				}
			}
		} else if (feats[4] == 1){
			if(feats[25] == 0) {
				if (debug){
					System.out.println("GOOD. Spot had: yes 4 (sheep),  no  25(on 1 tile).");
				}
				return true;
			} else if (feats[25]== 1){
				if (feats[38] == 0){
					if (feats[43] == 0){
						if (feats[33] == 0){
							if (feats[22] == 0){
								if (debug){
									System.out.println("BAD. Spot had: yes 4 (sheep),  yes 25(on 1 tile), no 38, no 43, no 33, no 22");
								}
								return false;
							} else if (feats[22] == 1){
								if (feats[17] == 0){
									if (feats [28] == 0){
										if (debug){
											System.out.println("GOOD. Spot had: yes 4 (sheep),  yes 25(on 1 tile), no 38, no 43, no 33, yes 22, no 17, no 28");
										}
										return true;
									} else if (feats[28] == 1){
										if (feats[18] == 0){
											if (debug){
												System.out.println("GOOD.  Spot had: yes 4 (sheep),  yes 25(on 1 tile), no 38, no 43, no 33, yes 22, no 17, yes 28, no 18");
											}
											return true;
										} else if (feats[18] == 1){
											if (feats[70] == 0){
												if (feats[8] == 0){
													if (debug){
														System.out.println("BAD. Spot had: yes 4 (sheep),  yes 25(on 1 tile), no 38, no 43, no 33, yes 22, no 17, yes 28, yes 18, no 70, no 8");
													}
													return false;
												} else if (feats [8] == 1){
													if (debug){
														System.out.println("GOOD. Spot had: yes 4 (sheep),  yes 25(on 1 tile), no 38, no 43, no 33, yes 22, no 17, yes 28, yes 18, no 70, yes 8");
													}
													return true;
												}
											} else if (feats[70] == 1){
												if (debug){
													System.out.println("BAD. Spot had: yes 4 (sheep),  yes 25(on 1 tile), no 38, no 43, no 33, yes 22, no 17, yes 28, yes 18, yes 70");
												}
												return false;
											}
										}
									}
								} else if (feats[17] == 1){
									if (feats[28] == 0){
										if (debug){
											System.out.println("BAD. Spot had: yes 4 (sheep), yes 25(on 1 tile), no 38, no 43, no 33, yes 22, yes 17, no 28");
										}
										return false;
									} else if (feats[28] == 1){
										if (debug){
											System.out.println("GOOD. Spot had: yes 4 (sheep), yes 25(on 1 tile), no 38, no 43, no 33, yes 22, yes 17, yes 28");
										}
										return true;
									}
								}
							}
						} else if (feats [33] == 1){
							if (debug){
								System.out.println("GOOD. Spot had: yes 4 (sheep), yes 25(on 1 tile), no 38, no 43, yes 33");
							}
							return true;
						}
					} else if (feats[43] == 1){
						if (debug){
							System.out.println("BAD. Spot had: yes 4 (sheep), yes 25(on 1 tile), no 38, yes 43");
						}
						return false;
					}
				} else if (feats[38] == 1){
					if (debug){
						System.out.println("BAD. Spot had: yes 4 (sheep), yes 25(on 1 tile), yes 38 (2 or 12 sheep)");
					}
					return false;
				}
			}
		}
		if (debug){
			System.out.println("Spot did not fall within any decision tree cases. Returning false");
		}
		
		return toReturn;
		
	
	}
	
}