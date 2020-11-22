package com.wangwenjun.cicd.chapter02;

import org.junit.Test;
import org.w3c.dom.Document;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestUsageTest
{

    //below is about beans
    @Test
    public void testHasProperty()
    {
        final SimpleBean bean = new SimpleBean();
        assertThat(bean, hasProperty("name"));
    }

    @Test
    public void testHasPropertyWithValue()
    {
        final SimpleBean bean = new SimpleBean("Alex", 35);
        assertThat(bean, hasProperty("name", is(equalTo("Alex"))));
        assertThat(bean, hasProperty("age", is(equalTo(35))));
    }

    @Test
    public void testSamePropertyValuesAs()
    {
        final SimpleBean bean1 = new SimpleBean("Alex", 35);
        final SimpleBean bean2 = new SimpleBean("Alex", 35);
        final SimpleBean bean3 = new SimpleBean("Alex", 100);
        assertThat(bean1, samePropertyValuesAs(bean2));
        assertThat(bean1, samePropertyValuesAs(bean3, "age"));
    }

    //below is about collection
    @Test
    public void testIsArray()
    {
        Integer[] actually = {1, 2, 3};
        assertThat(actually, is(array(equalTo(1), equalTo(2), equalTo(3))));

        //below assertion will failed due to not ordered.
        //assertThat(actually, is(array(equalTo(1), equalTo(3), equalTo(2))));
    }

    @Test
    public void testHasItemInArray()
    {
        String[] actually = {"foo", "bar"};
        assertThat(actually, hasItemInArray(is("foo")));
        assertThat(actually, hasItemInArray(startsWith("ba")));
    }

    @Test
    public void testIsArrayWithSize()
    {
        Integer[] actually = {1, 2, 3};
        assertThat(actually, arrayWithSize(3));
        assertThat(actually, arrayWithSize(is(3)));
        assertThat(actually, arrayWithSize(equalTo(3)));
        assertThat(actually, is(not(emptyArray())));
    }

    @Test
    public void testIsArrayContainingInOrder()
    {
        Integer[] actually = {1, 2, 3};
        assertThat(actually, arrayContaining(1, 2, 3));
        assertThat(actually, arrayContaining(equalTo(1), equalTo(2), equalTo(3)));
        assertThat(actually, arrayContaining(Arrays.asList(equalTo(1), equalTo(2), equalTo(3))));
    }

    @Test
    public void testArrayContainingInAnyOrder()
    {
        Integer[] actually = {1, 2, 3};
        assertThat(actually, arrayContainingInAnyOrder(equalTo(1), equalTo(3), equalTo(2)));
        assertThat(actually, arrayContainingInAnyOrder(1, 3, 2));
        assertThat(actually, arrayContainingInAnyOrder(Arrays.asList(equalTo(1), equalTo(3), equalTo(2))));
    }

    @Test
    public void testIsCollectionWithSize()
    {
        Collection<Integer> actually = Arrays.asList(1, 2, 3);
        assertThat(actually, hasSize(3));
        assertThat(actually, hasSize(equalTo(3)));
    }

    @Test
    public void testIsEmptyCollection()
    {
        Collection<Integer> actually = Collections.emptyList();
        assertThat(actually, empty());
        assertThat(actually, emptyCollectionOf(Integer.class));
    }

    @Test
    public void testIsEmptyIterable()
    {
        Collection<Integer> actually = Collections.emptyList();
        assertThat(actually, emptyIterable());
        assertThat(actually, emptyIterableOf(Integer.class));
    }

    @Test
    public void testIsMapContaining()
    {
        Map<String, String> actually = new HashMap<String, String>()
        {
            {
                put("Alex", "Hello Alex");
                put("Wang", "Hello Wang");
                put("Tina", "Hello Tina");
            }
        };

        assertThat(actually, hasEntry("Alex", "Hello Alex"));
        assertThat(actually, hasEntry(is("Alex"), endsWith("Alex")));

        assertThat(actually, hasKey("Wang"));
        assertThat(actually, hasKey(is(equalTo("Wang"))));

        assertThat(actually, hasValue("Hello Alex"));
        assertThat(actually, hasValue(is("Hello Alex")));
    }

    @Test
    public void testIsIn()
    {
        assertThat(1, isIn(Arrays.asList(1, 2, 3)));
        assertThat(1, is(in(Arrays.asList(1, 2, 3))));
        assertThat(1, isIn(new Integer[]{1, 2, 3}));
        assertThat(1, is(in(new Integer[]{1, 2, 3})));
        assertThat(1, oneOf(1, 2, 3));
    }

    @Test
    public void testIsIterableContainingInAnyOrder()
    {
        Collection<Integer> actually = Arrays.asList(1, 2, 3);
        assertThat(actually, containsInAnyOrder(equalTo(1), equalTo(3), equalTo(2)));
        assertThat(actually, containsInAnyOrder(2, 3, 1));
    }

    @Test
    public void testIsIterableContainingInOrder()
    {
        assertThat(Arrays.asList("foo", "bar"), contains("foo", "bar"));
        assertThat(Arrays.asList("foo"), contains(equalTo("foo")));
        assertThat(Arrays.asList("foo", "bar"), contains(equalTo("foo"), equalTo("bar")));
        assertThat(Arrays.asList("foo", "bar"), contains(Arrays.asList(equalTo("foo"), equalTo("bar"))));
    }

    @Test
    public void testIsIterableWithSize()
    {
        assertThat(Arrays.asList("foo", "bar"), iterableWithSize(equalTo(2)));
        assertThat(Arrays.asList("foo", "bar"), iterableWithSize(2));
    }

    //below is about number
    @Test
    public void testIsCloseTo()
    {
        /*
        operand - the expected value of matching doubles
        error - the delta (+/-) within which matches will be allowed
        */
        //1.0为期望的操作数而0.04则是delta值
        assertThat(1.03, is(closeTo(1.0, 0.04)));
    }

    @Test
    public void testBigDecimalCloseTo()
    {
        /**
         * operand - the expected value of matching BigDecimals
         * error - the delta (+/-) within which matches will be allowed
         */
        //1.0为期望的操作数而0.03则是delta值
        assertThat(new BigDecimal("1.03"), is(closeTo(new BigDecimal("1.0"), new BigDecimal("0.03"))));
    }

    @Test
    public void testOrderingComparison()
    {
        //2>1
        assertThat(2, greaterThan(1));
        //1>=1
        assertThat(1, greaterThanOrEqualTo(1));
        //1<2
        assertThat(1, lessThan(2));
        //1<=1
        assertThat(1, lessThanOrEqualTo(1));

        //H的ascii码<W的ascii码
        assertThat("Hello", lessThan("World"));
    }

    //below is about text Matcher
    @Test
    public void testIsEmptyString()
    {
        //字符串为空或者null，已被标记过期，请使用下一行代码
        assertThat((String) null, isEmptyOrNullString());
        //同上一行代码等价，但未被标记过期
        assertThat((String) null, is(emptyOrNullString()));

        //字符串为空或，已被标记过期，请使用下一行代码
        assertThat("", isEmptyString());

        //同上一行代码等价，但未被标记过期
        assertThat("", is(emptyString()));
    }

    @Test
    public void testIsEqualIgnoringCase()
    {
        //忽略大小写匹配字符串
        assertThat("alex", equalToIgnoringCase("ALEX"));
    }

    @Test
    public void testIsEqualIgnoringWhiteSpace()
    {
        //忽略空格匹配字符串，但是该方法已被注释为过期方法
        assertThat("   my\tfoo  bar ", equalToIgnoringWhiteSpace(" my  foo bar"));
        //等价上一个行代码，但未被标记过期
        assertThat("   my\tfoo  bar ", equalToCompressingWhiteSpace(" my  foo bar"));
    }

    @Test
    public void testStringContainsInOrder()
    {
        //断言匹配"alexwangwenjun"中的文本顺序："alex"前与"jun"
        assertThat("alexwangwenjun", stringContainsInOrder(Arrays.asList("alex", "jun")));
    }

    //below is about xml matcher
    @Test
    public void testHasXPath() throws Exception
    {
        //自定义xml命名空间
        final NamespaceContext ns = new NamespaceContext()
        {

            public String getNamespaceURI(String prefix)
            {
                return "www.wangwenjun.com/profile";
            }

            public String getPrefix(String namespaceURI)
            {
                return "alex";
            }

            public Iterator getPrefixes(String namespaceURI)
            {
                return Arrays.asList("alex").iterator();
            }
        };

        //定义包含命名空间的xml
        String actuallyXml = "<?xml version = \"1.0\" encoding = \"UTF-8\"?>" +
                "<alex:contact xmlns:alex = \"www.wangwenjun.com/profile\">" +
                "<alex:name>Wangwenjun</alex:name>" +
                "<alex:age>35</alex:age>" +
                "</alex:contact>";
        //将xml解析为Document
        Document xmlNode = parse(actuallyXml);
        //断言匹配该document满足"/contact/age" xpath表达式，即包含有age节点
        assertThat(xmlNode, hasXPath("/contact/age"));
        //断言匹配该document满足"/contact/age" xpath表达式，即包含有age节点且在ns命名空间下
        assertThat(xmlNode, hasXPath("/contact/age", ns));
        //断言匹配该document满足"/contact/name" 且name节点的值为"wangwenjun"(忽略大小写)
        assertThat(xmlNode, hasXPath("/contact/name", is(equalToIgnoringCase("wangwenjun"))));
        //断言匹配该document满足"/contact/age" 且age节点的值为"35"，同样咋子ns命名空间下
        assertThat(xmlNode, hasXPath("/contact/age", ns, equalTo("35")));
    }

    private Document parse(String xml) throws Exception
    {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(false);
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        return documentBuilder.parse(new ByteArrayInputStream(xml.getBytes()));
    }

    //below is about core

    @Test
    public void testAllOf()
    {
        String actually = "Hello Hamcrest";
        //只有当下列匹配条件都满足时，才能断言通过

        //actually和"Hello Hamcrest"是equal的
        assertThat(actually, allOf(is(equalTo("Hello Hamcrest")),
                //actually中包含字符串"llo Ha"
                containsString("llo Ha"),
                //actually是以"Hello"开头的
                startsWith("Hello"),
                //actually是以"crest"结尾的
                endsWith("crest"),
                //actually是String类型的一个实例
                instanceOf(String.class),
                //actually不为null
                notNullValue(),
                stringContainsInOrder("Hello", "Hamcrest"))
        );

        //与上面写法等价.
        assertThat(actually, allOf(Arrays.asList(
                is(equalTo("Hello Hamcrest")),
                //actually中包含字符串"llo Ha"
                containsString("llo Ha"),
                //actually是以"Hello"开头的
                startsWith("Hello"),
                //actually是以"Hello"结尾的
                endsWith("crest"),
                //actually是String类型的一个实例
                instanceOf(String.class),
                //actually不为null
                notNullValue(),
                stringContainsInOrder("Hello", "Hamcrest")))
        );
    }

    @Test
    public void testAnyOf()
    {
        String actually = "Hello Hamcrest";
        //下列匹配条件只要有一个满足时，就能断言通过
        //actually和"Hello Hamcrest1"是equal的 ×
        assertThat(actually, anyOf(is(equalTo("Hello Hamcrest1")),
                //actually中包含字符串"llo Xa" ×
                containsString("llo Ha"),
                //actually是以"Hello"开头的 √
                startsWith("Hello"),
                //actually是以"crest"结尾的 ×
                endsWith("crest?"),
                //actually是Integer类型的一个实例 ×
                instanceOf(Integer.class),
                //actually不为null ×
                nullValue(),
                //顺序错误 ×
                stringContainsInOrder("Hamcrest", "Hello"))
        );

        //与上面写法等价.
        //actually和"Hello Hamcrest1"是equal的 ×
        assertThat(actually, anyOf(Arrays.asList(
                is(equalTo("Hello Hamcrest1")),
                //actually中包含字符串"llo Xa" ×
                containsString("llo Ha"),
                //actually是以"Hello"开头的 √
                startsWith("Hello"),
                //actually是以"crest"结尾的 ×
                endsWith("crest?"),
                //actually是Integer类型的一个实例 ×
                instanceOf(Integer.class),
                //actually不为null ×
                nullValue(),
                //顺序错误 ×
                stringContainsInOrder("Hamcrest", "Hello")))
        );
    }

    @Test
    public void testBoth()
    {
        String actually = "Hello Hamcrest";
        assertThat(actually, both(
                allOf(
                        //actually和"Hello Hamcrest"是equal的
                        is(equalTo("Hello Hamcrest")),
                        //actually中包含字符串"llo Ha"
                        containsString("llo Ha"),
                        //actually是以"Hello"开头的
                        startsWith("Hello"),
                        //actually是以"crest"结尾的
                        endsWith("crest"))
                ).and(
                allOf(
                        instanceOf(String.class),
                        //actually不为null
                        notNullValue(),
                        //顺序正确
                        stringContainsInOrder("Hello", "Hamcrest")
                )
                )
        );
    }

    @Test
    public void testEither()
    {
        String actually = "Hello Hamcrest";
        //和"Hello Hamcrest"相等或和null相等只要满足一个即可
        assertThat(actually, either(is(equalTo("Hello Hamcrest"))).or(nullValue()));
    }
}
