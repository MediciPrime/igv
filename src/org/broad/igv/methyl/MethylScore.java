/*
 * Copyright (c) 2007-2012 The Broad Institute, Inc.
 * SOFTWARE COPYRIGHT NOTICE
 * This software and its documentation are the copyright of the Broad Institute, Inc. All rights are reserved.
 *
 * This software is supplied without any warranty or guaranteed support whatsoever. The Broad Institute is not
 * responsible for its use, misuse, or functionality.
 *
 * This software is licensed under the terms of the GNU Lesser General Public License (LGPL), Version 2.1 which is
 * available at http://www.opensource.org/licenses/lgpl-2.1.php.
 */

package org.broad.igv.methyl;

import org.broad.igv.feature.LocusScore;
import org.broad.igv.track.WindowFunction;

/**
 * @author Jim Robinson
 * @date 4/19/12
 */
public class MethylScore implements LocusScore {

    String chr;
    int start;
    int end;
    short percentMethylated;
    short totalCount;

    public MethylScore(String chr, int start, int end, short percentMethylated, short totalCount) {
        this.chr = chr;
        this.end = end;
        this.percentMethylated = percentMethylated;
        this.start = start;
        this.totalCount = totalCount;
    }

    public float getScore() {
        return percentMethylated;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Return a string to be used for popup text.   The WindowFunction is passed
     * in so it can be used t annotate the value.  The LocusScore object itself
     * does not "know" from what window function it was derived
     *
     * @param position       Zero-based genome position
     * @param windowFunction
     * @return
     */
    public String getValueString(double position, WindowFunction windowFunction) {
        String totalCountString = totalCount < Short.MAX_VALUE ? String.valueOf(totalCount) :
                "> " + Short.MAX_VALUE;
        return percentMethylated + "%" + " [" + totalCountString + "]";
    }

    /**
     * Return the features reference sequence name, e.g chromosome or contig
     */
    public String getChr() {
        return chr;
    }

    /**
     * Return the start position
     */
    public int getStart() {
        return start;
    }

    /**
     * Return the end position
     */
    public int getEnd() {
        return end;
    }


    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
