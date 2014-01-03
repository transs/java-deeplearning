package com.ccc.deeplearning.word2vec;

import org.jblas.DoubleMatrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ccc.deeplearning.util.MatrixUtil;

public class SkipGramTest {

	private static Logger log = LoggerFactory.getLogger(SkipGramTest.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double alpha = 0.025;
		DoubleMatrix code = DoubleMatrix.zeros(1);
		DoubleMatrix l1 = new DoubleMatrix(new double[]{
				
				-1.73355103e-03,  2.70581018e-04,  3.85942101e-03, -1.42730237e-03
				,  4.08535171e-03,  1.23360113e-03, -4.84178774e-03,  4.29437216e-03
				,  1.90896913e-03,  4.97322856e-03, -3.27659491e-03, -3.62864253e-03
				,  4.32595471e-03,  1.96818169e-03, -4.33999812e-03,  2.55463063e-03
				,  2.53876182e-03,  4.23024548e-03,  2.11524754e-03, -3.75729031e-03
				, -4.80119884e-03, -4.73789033e-03, -4.71693510e-03, -2.53788941e-03
				,  3.60027957e-03,  3.88310640e-04,  5.28219796e-04,  3.42030893e-03
				, -3.75826680e-03, -2.20816326e-03,  8.57592735e-04,  4.69595753e-03
				,  6.10302202e-04, -4.81352722e-03,  3.00632673e-03, -2.67025735e-03
				,  3.07105202e-03, -1.12139352e-03,  3.63541860e-03,  2.47121649e-03
				,  5.62402362e-04, -3.63544771e-03, -4.40082327e-03, -3.78656550e-03
				, -4.55448125e-03, -3.92505853e-03, -2.74290657e-03,  2.12988979e-03
				,  5.97169797e-04, -4.87444038e-03, -4.28025704e-03,  4.67276340e-03
				,  6.81004603e-04, -2.96706776e-03, -2.47674249e-03,  2.43825861e-03
				, -3.04570515e-03,  8.13589257e-04,  4.70019970e-03,  3.46828811e-03
				, -2.60152249e-03, -6.23028609e-05,  1.19955721e-03,  3.28980898e-03
				, -3.43208597e-03, -4.81423782e-03, -4.29977849e-03, -1.36548886e-04
				,  1.06329459e-03,  6.88514381e-04, -1.82637596e-03,  4.88616154e-03
				,  7.97452172e-04, -1.19858829e-03,  5.09482168e-04,  2.45334441e-03
				,  1.69232895e-03, -2.35080440e-03, -4.33665188e-03, -1.29915797e-03
				,  1.29717507e-03, -2.89825979e-03,  2.52755545e-03, -4.33463510e-03
				, -2.39684898e-03,  3.04754567e-03, -3.06565710e-03,  1.39460876e-03
				,  2.46703101e-04,  4.24807984e-03, -2.36703223e-03, -4.34038928e-03
				,  2.35065958e-03,  2.72178021e-03,  4.07815864e-03,  4.31972090e-03
				, -4.86048404e-03, -2.65637925e-03,  1.16778351e-03,  4.49016318e-03});

		DoubleMatrix l2a = new DoubleMatrix(new double[][] {
				{ 

					0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0
					,  0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0
					,  0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0
					,  0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0
					,  0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0
					,  0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}
		,
		{ 

			0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0
			,  0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0
			,  0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0
			,  0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0
			,  0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0
			,  0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}
		
		});
		DoubleMatrix ret = MatrixUtil.dot(l1, l2a.transpose());
		System.out.println(ret);
		DoubleMatrix fa = MatrixUtil.sigmoid(ret);
		DoubleMatrix ga = DoubleMatrix.ones(fa.length).sub(code).sub(fa).mul(alpha);
		DoubleMatrix outer = ga.mul(l1);
		DoubleMatrix l2aPlus = l2a.addi(outer);
		DoubleMatrix gaDot = ga.mul(l2aPlus);
		DoubleMatrix l1Plus = l1.addi(gaDot);
		log.info(l1Plus.toString());
		//fa = 1.0 / (1.0 + exp(-dot(l1, l2a.T)))  #  propagate hidden -> output
		//l2a += outer(ga, l1)  # learn hidden -> output


		//l1 += dot(ga, l2a)  # learn input -> hidden
		System.out.println("Done");

	}

}