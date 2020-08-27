class FindAllDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> returnArray=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i])-1;
            if(nums[index]<0){
                returnArray.add(index+1);
            }else{
                nums[index]=0-nums[index];
            }
        }
        return returnArray;
    }
}
