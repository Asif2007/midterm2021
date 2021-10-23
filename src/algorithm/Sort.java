package algorithm;

public class Sort {

    long executionTime = 0;
    /*
     * Please implement all the sorting algorithm. Feel free to add helper methods.
     * Store all the sorted data into one of the databases.
     */


    public int[] selectionSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }

        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public int[] insertionSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;
        //implement here
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }


        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public int[] bubbleSort(int[] array) {
        int[] list = array;
        //implement here
        boolean swap = true;
        int temp;

        while (swap) {

            swap = false;

            for (int i = 0; i < list.length - 1; i++) {
                if (list[i] > list[i + 1]) {
                    temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    swap = true;
                }
            }
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime;
        this.executionTime = executionTime;
        return list;
    }


    public int[] mergeSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;
        //implement here
        if (array.length > 1) {
            int mid = array.length / 2;
            int leftArray[] = new int[mid];
            int rightArray[] = new int[array.length - mid];
            for (int i = 0; i < mid; i++) { //copy left
                leftArray[i] = array[i];
            }
            for (int i = 0; i < array.length - mid; i++) { //copy right
                rightArray[i] = array[mid + i];
            }
            mergeSort(leftArray);
            mergeSort(rightArray);

            int i = 0;
            int j = 0;
            int k = 0;

            while (i < leftArray.length && j < rightArray.length) {
                if (leftArray[i] < rightArray[j]) {
                    array[k] = leftArray[i];
                    i++;
                } else {
                    array[k] = rightArray[j];
                    j++;
                }
                k++;
            }
            while (i < leftArray.length) {
                array[k++] = leftArray[i++];
            }
            while (j < rightArray.length) {
                array[k++] = rightArray[j++];
            }
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }


    public int[] quickSort(int[] array, int left, int right) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;
        //implement here
        if (array.length > 1) {
            int pivot = array[left + (right - left) / 2];
            int i = left;
            int j = right;
            while (i <= j) {
                while (array[i] < pivot) {
                    i++;
                }
                while (array[j] > pivot) {
                    j--;
                }
                if (i <= j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    i++;
                    j--;
                }
            }

            if (left < j)
                quickSort(array, left, j);
            if (i < right)
                quickSort(array, i, right);
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public int[] heapSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;
        //implement here
        int n = list.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(list, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = list[0];
            list[0] = list[i];
            list[i] = temp;

            heapify(list, i, 0);
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public int[] bucketSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;
        //implement here
        int maxValue = 0;
        for (int i = 0; i < array.length; i++)
            if (array[i] > maxValue)
                maxValue = array[i];
        int[] Bucket = new int[maxValue + 1];
        for (int i = 0; i < array.length; i++)
            Bucket[array[i]]++;
        int outPos = 0;
        for (int i = 0; i < Bucket.length; i++)
            for (int j = 0; j < Bucket[i]; j++)
                list[outPos++] = i;

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public int[] shellSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;
        //implement here
        int h = 1;
        while (h < list.length) h = 3 * h + 1;
        while (h > 0) {
            h = h / 3;
            for (int k = 0; k < h; k++) {
                for (int i = h + k; i < list.length; i += h) {
                    int key = list[i];
                    int j = i - h;
                    while (j >= 0 && list[j] > key) {
                        list[j + h] = list[j];
                        j -= h;
                    }
                    list[j + h] = key;
                }
            }
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public static void printSortedArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i;  // Initialize largest as root
        int l = 2 * i + 1;  // left = 2*i + 1
        int r = 2 * i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}