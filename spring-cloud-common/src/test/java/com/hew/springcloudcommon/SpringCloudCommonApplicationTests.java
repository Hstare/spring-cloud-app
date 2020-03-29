package com.hew.springcloudcommon;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class SpringCloudCommonApplicationTests {

    @Test
    void contextLoads() {
    }

    /*
     * 初始化数据
     * [{"path":"0001","id":1,"text":"北京"},
     * {"path":"00010001","id":2,"text":"朝阳","parentId":1},
     * {"path":"00010002","id":3,"text":"海淀","parentId":1},
     * {"path":"00010003","id":4,"text":"西单","parentId":1},
     * {"path":"000100010001","id":5,"text":"朝阳子1","parentId":2},
     * {"path":"000100010002","id":6,"text":"朝阳子2","parentId":2},
     * {"path":"000100010003","id":7,"text":"朝阳子3","parentId":2},
     * {"path":"000100020001","id":8,"text":"海淀子1","parentId":3},
     * {"path":"000100020002","id":9,"text":"海淀子2","parentId":3}]
     * */
    public List<Map<String, Object>> getListData(){
        Map<String, Object> data1 = new HashMap<String, Object>();
        data1.put("id", 1);
        data1.put("parentId", null);
        data1.put("path", "0001");
        data1.put("text", "北京");

        Map<String, Object> data2 = new HashMap<String, Object>();
        data2.put("id", 2);
        data2.put("parentId", 1);
        data2.put("path", "00010001");
        data2.put("text", "朝阳");

        Map<String, Object> data3 = new HashMap<String, Object>();
        data3.put("id", 3);
        data3.put("parentId", 1);
        data3.put("path", "00010002");
        data3.put("text", "海淀");

        Map<String, Object> data4 = new HashMap<String, Object>();
        data4.put("id", 4);
        data4.put("parentId", 1);
        data4.put("path", "00010003");
        data4.put("text", "西单");

        Map<String, Object> data5 = new HashMap<String, Object>();
        data5.put("id", 5);
        data5.put("parentId", 2);
        data5.put("path", "000100010001");
        data5.put("text", "朝阳子1");

        Map<String, Object> data6 = new HashMap<String, Object>();
        data6.put("id", 6);
        data6.put("parentId", 2);
        data6.put("path", "000100010002");
        data6.put("text", "朝阳子2");

        Map<String, Object> data7 = new HashMap<String, Object>();
        data7.put("id", 7);
        data7.put("parentId", 2);
        data7.put("path", "000100010003");
        data7.put("text", "朝阳子3");

        Map<String, Object> data8 = new HashMap<String, Object>();
        data8.put("id", 8);
        data8.put("parentId", 3);
        data8.put("path", "000100020001");
        data8.put("text", "海淀子1");

        Map<String, Object> data9 = new HashMap<String, Object>();
        data9.put("id", 9);
        data9.put("parentId", 3);
        data9.put("path", "000100020002");
        data9.put("text", "海淀子2");

        List<Map<String, Object>> listData = new ArrayList<Map<String, Object>>();
        listData.add(data1);
        listData.add(data2);
        listData.add(data3);
        listData.add(data4);
        listData.add(data5);
        listData.add(data6);
        listData.add(data7);
        listData.add(data8);
        listData.add(data9);

        return listData;
    }

    @Test
    public void test1() throws Exception{

        List<Map<String, Object>> listData = getListData();

        List<Map<String, Object>> treeList = recursion(null, listData);

        System.out.println(treeList);

    }

    //递归获取树型结构数据
    public List<Map<String, Object>> recursion(Integer id, List<Map<String, Object>> listData) throws Exception{
        List<Map<String, Object>> treeList = new ArrayList<Map<String, Object>>();
        Iterator it = listData.iterator();
        while (it.hasNext()){
            Map<String, Object> map = (Map<String, Object>)it.next();
            if (map.get("parentId") == id){
                treeList.add(map);
                //使用Iterator，以便在迭代时把listData中已经添加到treeList的数据删除，迭代次数
                it.remove();
            }
        }
        for(Map<String, Object> map:treeList){
            map.put("childrenList", recursion((Integer)map.get("id"), listData));
        }
        return treeList;
    }

}
