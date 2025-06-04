package EPAMCoding.StreamsAndLambda;

public class Main {
    public static void main(String[] args) {
        FlattenMap.flattenMap();
        Reduce.reduce();

        ListToMap.listToMap();
        ListToMapWithDuplicateKey.listToMapWithDuplicates();

        CountFreqOfWords.countFreqOfWord();
        ParallelStream.parallelStream();

        DifferentCollectorsUsage.partitioningResult();
        DifferentCollectorsUsage.joiningResult();
        DifferentCollectorsUsage.groupbyResult();

        SortingInStreams.basicSort();
        SortingInStreams.sortUsingComparator();
        SortingInStreams.sortUsingMultipleConditions();
    }
}
