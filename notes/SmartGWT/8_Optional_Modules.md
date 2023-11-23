An overview of optional modules in Smart GWT

---

# Optional Modules in Smart GWT

Smart GWT provides a variety of optional modules that extend its functionality and offer additional features. These modules can be selectively included in your Smart GWT application based on your specific requirements.

## 1. **Charting**

### Purpose:
Enables the integration of interactive charts and graphs into your Smart GWT application.

### Integration Example:
```xml
<Window title="Chart Example" width="600" height="400">
    <VLayout>
        <HLayout>
            <IButton title="Show Chart" click="showChart" />
        </HLayout>
        <VLayout ID="chartContainer" width="100%" height="100%"></VLayout>
    </VLayout>
</Window>
```
```java
public void showChart() {
    Chart chart = new Chart();
    chart.setDataURL("data/chartData.json");
    
    VLayout chartContainer = (VLayout)Canvas.getById("chartContainer");
    chartContainer.addChild(chart);
}
```

## 2. **Calendar**

### Purpose:
Adds a fully-featured calendar component to your application for managing events and appointments.

### Integration Example:
```xml
<Window title="Calendar Example" width="800" height="600">
    <Calendar ID="myCalendar" width="100%" height="100%"></Calendar>
</Window>
```

## 3. **Tiles**

### Purpose:
Enables the creation of dynamic, tile-based layouts for building dashboards and home pages.

### Integration Example:
```xml
<TileLayout width="100%" height="100%" tileSize="150" layoutMargin="10">
    <TileGrid width="100%" height="100%" canReorderTiles="true">
        <!-- Tile definitions go here -->
    </TileGrid>
</TileLayout>
```

## 4. **Messaging**

### Purpose:
Facilitates real-time messaging and collaboration features within your Smart GWT application.

### Integration Example:
```java
Messaging.register("channel1");
Messaging.subscribe("channel1", new MessagingCallback() {
    @Override
    public void execute(Object[] properties) {
        // Handle incoming messages
    }
});
Messaging.send("channel1", "Hello, Smart GWT!");
```

## 5. **Drawing**

### Purpose:
Adds support for drawing and diagramming capabilities, allowing users to create and manipulate graphics.

### Integration Example:
```java
DrawPane drawPane = new DrawPane();
DrawRect drawRect = new DrawRect(30, 30, 100, 100);
drawRect.setBackgroundColor("lightblue");
drawPane.addDrawItem(drawRect);
```

## Conclusion

These optional modules enhance Smart GWT with specialized features catering to specific needs such as charting, calendar management, dynamic layouts, real-time messaging, and drawing capabilities. Selectively include the modules based on your application's requirements.

For more detailed information and examples, refer to the [official Smart GWT documentation](https://www.smartclient.com/smartgwt/showcase/).

---

This file provides an introduction to some of the optional modules available in Smart GWT, along with integration examples. Adjust the examples based on your specific use case and requirements.