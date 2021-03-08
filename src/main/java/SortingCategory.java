import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SortingCategory {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        JSONArray categoryArray = new JSONArray();

        //Sample Category details
        JSONObject categoryDetails1 = new JSONObject();
        categoryDetails1.put("name", "Accessories");
        categoryDetails1.put("id", 1);
        categoryDetails1.put("parent_id", 20);

        JSONObject categoryDetails2 = new JSONObject();
        categoryDetails2.put("name", "Watches");
        categoryDetails2.put("id", 57);
        categoryDetails2.put("parent_id", 1);

        JSONObject categoryDetails3 = new JSONObject();
        categoryDetails3.put("name", "Men");
        categoryDetails3.put("id", 20);
        categoryDetails3.put("parent_id", null);

        categoryArray.add(categoryDetails1);
        categoryArray.add(categoryDetails2);
        categoryArray.add(categoryDetails3);

        System.out.println("Unsorted Array of categories --->");
        System.out.println(categoryArray.toJSONString());

        JSONArray sortedCategoryArray = sortCategoriesForInsert(categoryArray);

        System.out.println("Sorted Array of categories --->");
        System.out.println(sortedCategoryArray.toJSONString());
    }

    //Find the root to sort the categories
    @SuppressWarnings("unchecked")
    private static JSONArray sortCategoriesForInsert(JSONArray categoryArray) {
        JSONArray sortedCategoryArray = new JSONArray();
        Integer parentId = null;

        for (int i = 0; i < categoryArray.size(); i++) {
            JSONObject jsonObbject = (JSONObject) categoryArray.get(i);

            //Find the root element STARTING with parent Id as null
            if (jsonObbject.get("parent_id") == null) {
                sortedCategoryArray.add(jsonObbject);
                parentId = Integer.parseInt(jsonObbject.get("id").toString());
                findChilderen(categoryArray, sortedCategoryArray, parentId);
                break;
            }
        }
        return sortedCategoryArray;
    }


    // sort all the childeren
    @SuppressWarnings("unchecked")
    private static void findChilderen(JSONArray categoryArray, JSONArray sortedCategoryArray, Integer id) {
        for (Object o : categoryArray) {
            JSONObject jsonObbject = (JSONObject) o;
            if (jsonObbject.get("parent_id") == id) {
                sortedCategoryArray.add(jsonObbject);
                id = Integer.parseInt(jsonObbject.get("id").toString());
                System.out.println("NEXT PARENT ID ->" + id);
                break;
            }
        }
        if (categoryArray.size() != sortedCategoryArray.size()) {
            findChilderen(categoryArray, sortedCategoryArray, id);
        }
    }
}
