package exercises.sorting;

/**
 * If you have a 2 GB file with one string per line, which sorting algorithm
 * would you use to sort the file and why?
 * 
 * @author lucas
 *
 */
public class E4 {

	public static void main(String[] args) {
		// The trick here is External Sort (https://en.wikipedia.org/wiki/External_sorting)
        // Assuming we only have a limited amount of RAM. Let it be 200MB. With only 200MB of RAM we cannot load the entire file
        // and sort it in place. We have to use external sort:
        //
        // 1. Load the file in chunks of 200MB, sort them inplace (e.g. using quicksort) and then write the sorted data to an output file on disk.
        // 2. Repeat step 1 until we read the entire file. For a 2GB file we will have 10 chunks.
        // 3. From every chunk read the first 15MB of data into an input buffer. With 10 chunks this would be a total of 150MB. Allocate 50MB for an output buffer.
        // 4. Perform a 10-way merge sort on the data and store the result in the output buffer. If the buffer is full, write the buffer data on disk and empty the buffer.
        //    If an input buffer is empty, read the next 15MB from the appropriate chunk until each chunk is fully processed.
	}

}
